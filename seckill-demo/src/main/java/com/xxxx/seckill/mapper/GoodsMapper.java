package com.xxxx.seckill.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.seckill.pojo.Goods;
import com.xxxx.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyx
 * @since 2021-03-05
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 查询所有GoodsVo
     * @return
     */
    List<GoodsVo> findGoodsVo();

//    /**
//     * 查询所有GoodsVo
//     *
//     * @return
//     */
//    List<GoodsVo> findGoodsVo();
//
//
//    /**
//     * 通过商品id查询GoodsVo
//     *
//     * @param goodId
//     * @return
//     */
//    GoodsVo findGoodsVoByGoodId(Long goodId);
//
//
//    void addGood(TGoods goods);
}
