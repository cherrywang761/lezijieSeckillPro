package com.xxxx.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author lyx
 * @since 2021-03-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id ，即为手机号
     */
    @TableId("id")
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * MD5(MD5(PASS明文 + 固定SALT) + SALT)
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 头像
     */
    private String head;

    /**
     * 注册时间
     */
    private Date registerDate;

    /**
     * 最后一次登录时间
     */
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;


}
