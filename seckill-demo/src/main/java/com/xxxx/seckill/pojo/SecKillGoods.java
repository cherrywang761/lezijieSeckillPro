package com.xxxx.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_seckill_goods")
public class SecKillGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableField("id")
    private Long id;

    /**
     * 秒杀价
     */
    @TableField("seckill_price")
    private BigDecimal secKillPrice;

    /**
     * 商品id
     */
    @TableField("good_id")
    private Long goodId;

    /**
     * 库存数量
     */
    private Integer stockCount;

    /**
     * 秒杀开始时间
     */
    private Date startDate;

    /**
     * 秒杀结束时间
     */
    private Date endDate;


}
