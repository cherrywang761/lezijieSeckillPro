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
import java.util.Date;
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
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        //秒杀状态
        int secKillStatus = 0;
        //秒杀倒计时
        int remainSecond = 0;
        //秒杀还未开始
        if(nowDate.before(startDate)){
            remainSecond = (int)((startDate.getTime()-nowDate.getTime())/1000);
        }else if(nowDate.after(endDate)){
            //秒杀已结束
            secKillStatus = 2;
            remainSecond = -1;
        }else{
            //秒杀中
            secKillStatus = 1;
            remainSecond = 0;
        }
        model.addAttribute("remainSeconds", remainSecond);
        model.addAttribute("secKillStatus", secKillStatus);
        model.addAttribute("goods", goodsVo);
        return "goodsDetail";
    }

}
