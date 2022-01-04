package com.xxxx.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.seckill.pojo.Order;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.vo.GoodsVo;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyx
 * @since 2021-03-05
 */
public interface IOrderService extends IService<Order> {


    Order seckill(User user, GoodsVo goodsVo);
}
