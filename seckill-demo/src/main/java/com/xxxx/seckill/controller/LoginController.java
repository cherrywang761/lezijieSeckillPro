package com.xxxx.seckill.controller;


import com.xxxx.seckill.service.IUserService;
import com.xxxx.seckill.vo.LoginVo;
import com.xxxx.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.interfaces.RSAKey;


/**
 * 登录
 *
 * @Package: com.SecKillpro.SecKill_pro.controller
 * @ClassName: LoginController
 * @Author: lyx
 * @CreateTime: 2021/3/3 10:59
 * @Description:
 */

@Controller
@RequestMapping(value = "/login")
@Slf4j
public class LoginController{

    @Autowired
    IUserService iUserService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }


    /**
     * 登录功能
     * @param vo
     * @return
     */
    @RequestMapping(value = "/doLogin")
    public @ResponseBody RespBean doLogin(@Valid LoginVo vo,
                                          HttpServletRequest request,
                                          HttpServletResponse response){
        return iUserService.doLogin(vo, request, response);
    }
}