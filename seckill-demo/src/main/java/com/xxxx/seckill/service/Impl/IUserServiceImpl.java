package com.xxxx.seckill.service.Impl;

import com.xxxx.seckill.exception.GlobalException;
import com.xxxx.seckill.mapper.UserMapper;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IUserService;
import com.xxxx.seckill.utils.CookieUtil;
import com.xxxx.seckill.utils.MD5Util;
import com.xxxx.seckill.utils.UUIDUtil;
import com.xxxx.seckill.utils.ValidatorUtil;
import com.xxxx.seckill.vo.LoginVo;
import com.xxxx.seckill.vo.RespBean;
import com.xxxx.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.security.krb5.internal.PAData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName IUserServiceImpl
 * @Description TODO
 * @Author 86137
 * @Date 2021-12-23 22:17
 * @Version 1.0
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 登录逻辑
     * @param vo
     * @return
     */
    @Override
    public RespBean doLogin(LoginVo vo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = vo.getMobile();
        String password = vo.getPassword();
        System.out.println(password);
        User user = userMapper.selectById(mobile);
        if(null == user){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //判断密码是否正确
        if(!MD5Util.formPassToDBPass(password, user.getSalt()).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //生成cookie
        String ticket = UUIDUtil.uuid();
        redisTemplate.opsForValue().set("user:" + ticket, user);
        CookieUtil.setCookie(request, response, "userTicket", ticket);
        return RespBean.success();
    }

    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if(StringUtils.isEmpty(userTicket)){
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        if(user != null){
            CookieUtil.setCookie(request, response, "userTicket", userTicket);
        }
        return user;
    }
}
