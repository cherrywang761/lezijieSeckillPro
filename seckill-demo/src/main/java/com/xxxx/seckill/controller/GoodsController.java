package com.xxxx.seckill.controller;

import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IGoodsService;
import com.xxxx.seckill.service.IUserService;
import com.xxxx.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Autowired
    private IGoodsService goodsService;

    /**
     * 跳转到商品列表页
     *
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/toList")
    public String toList(Model model, User user) {
        model.addAttribute("user", user);
        List<GoodsVo> goodsVo = goodsService.findGoodsVo();
        model.addAttribute("goodsList", goodsVo);
        return "goodsList";
    }


    /**
     * 跳转用户详情页面
     * @param GoodsId
     * @return
     */
    @RequestMapping(value = "/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId){
        model.addAttribute("user", user);
        model.addAttribute("goods", goodsService.findGoodsVoByGoodsId(goodsId));
        return "goodsDetail";
    }

}
