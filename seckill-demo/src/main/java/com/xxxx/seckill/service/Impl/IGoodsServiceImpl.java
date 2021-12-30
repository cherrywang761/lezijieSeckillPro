package com.xxxx.seckill.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.seckill.mapper.GoodsMapper;
import com.xxxx.seckill.pojo.Goods;
import com.xxxx.seckill.service.IGoodsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyx
 * @since 2021-03-05
 */
@Service
public class IGoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
