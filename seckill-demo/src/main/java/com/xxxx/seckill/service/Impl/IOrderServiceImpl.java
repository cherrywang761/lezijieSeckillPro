package com.xxxx.seckill.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.seckill.mapper.OrderMapper;
import com.xxxx.seckill.pojo.Order;
import com.xxxx.seckill.pojo.SecKillGoods;
import com.xxxx.seckill.pojo.SecKillOrder;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IOrderService;
import com.xxxx.seckill.service.ISecKillGoodsService;
import com.xxxx.seckill.service.ISecKillOrderService;
import com.xxxx.seckill.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyx
 * @since 2021-03-05
 */

@Transactional
@Service
@Slf4j
public class IOrderServiceImpl
        extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private ISecKillGoodsService secKillGoodsService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ISecKillOrderService secKillOrderService;

    /**
     * 秒杀
     * @param user
     * @param goodsVo
     * @return
     */
    @Override
    public Order seckill(User user, GoodsVo goodsVo) {
        //秒杀商品表减库存
        SecKillGoods secKillGoods = secKillGoodsService.getOne(new QueryWrapper<SecKillGoods>().eq("goods_id", goodsVo.getId()));
        secKillGoods.setStockCount(secKillGoods.getStockCount() - 1);
        Order order = new Order();
        order.setUserId(user.getId());
        order.setGoodId(goodsVo.getId());
        order.setDeliveryAddrId(0L);
        order.setGoodName(goodsVo.getGoodsName());
        order.setGoodCount(1);
        order.setGoodPrice(secKillGoods.getSecKillPrice());
        order.setOrderChannel(1);
        order.setStatus(0);
        order.setCreateDate(new Date());

        orderMapper.insert(order);

        //生成秒杀订单
        SecKillOrder secKillOrder = new SecKillOrder();
        secKillOrder.setUserId(user.getId());
        secKillOrder.setGoodId(goodsVo.getId());
        secKillOrder.setOrderId(order.getId());
        secKillGoodsService.save(secKillGoods);

        return order;
    }
}
