package com.xxxx.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long goodId;

    /**
     * 收货地址
     */
    private Long deliveryAddrId;

    /**
     * 冗余过来的商品名称
     */
    private String goodName;

    /**
     * 商品数量
     */
    private Integer goodCount;

    /**
     * 商品单价
     */
    private BigDecimal goodPrice;

    /**
     * 1 pc 2 android,3 ios
     */
    private Integer orderChannel;

    /**
     * 订单状态， 0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成
     */
    private Integer status;

    /**
     * 订单创建时间
     */
    private Date createDate;

    /**
     * 支付时间
     */
    private Date payDate;


}
