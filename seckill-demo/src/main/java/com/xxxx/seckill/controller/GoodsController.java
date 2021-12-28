package com.xxxx.seckill.controller;

import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName GoodsController
 * @Description 商品控制层
 * @Author 86137
 * @Date 2021-12-26 23:00
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    IUserService iUserService;

    /**
     * 跳转到商品列表页
     *
     * @param session
     * @param model
     * @param ticket
     * @return
     */
    @RequestMapping(value = "/toList")
    public String toList(HttpServletRequest request,
                         HttpServletResponse response,
                         Model model,
                         @CookieValue("userTicket") String ticket) {
        if (StringUtils.isEmpty(ticket)) {
            //如果cookie为空，就跳转回登录
            return "login";
        }
        User user = iUserService.getUserByCookie(ticket, request, response);
        if (null == user) {
            return "login";
        }
        model.addAttribute("user", user);
        return "goodsList";
    }

}
