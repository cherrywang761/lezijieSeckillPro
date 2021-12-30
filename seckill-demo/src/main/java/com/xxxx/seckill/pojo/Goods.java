package com.xxxx.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author lyx
 * @since 2021-03-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@TableName("t_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Long id;

    /**
     * 商品名称
     */

    private String goodName;

    /**
     * 商品标题
     */
    private String goodTitle;

    /**
     * 商品图片路径
     */
    private String goodImg;

    /**
     * 商品详情
     */
    private String goodDetail;

    /**
     * 商品价格
     */
    private BigDecimal goodPrice;

    /**
     * 商品库存，-1 表示没有限制
     */
    private Integer goodStock;


}
