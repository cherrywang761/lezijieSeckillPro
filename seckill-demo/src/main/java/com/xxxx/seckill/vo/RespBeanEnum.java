package com.xxxx.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Package: com.SecKillpro.SecKill_pro.vo
 * @ClassName: RespBeanEnum
 * @Author: lyx
 * @CreateTime: 2021/3/3 11:15
 * @Description: 公共返回对象枚举
 */

@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {

    //通用
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务器异常"),

    //登录模块5002xx
    LOGIN_ERROR(500210, "用户名或密码不正确"),
    MOBILE_ERROR(500211, "手机格式不正确"),
    BIND_ERROR(500212, "参数校验异常"),
    MOBILE_NOT_EXIST(500513, "用户不存在"),
    UPDATE_FAIL(500514, "修改密码失败"),
    SESSION_ERROR(500515, "用户不存在"),
    //秒杀模块5005xx
    EMPTY_STOCK(500500, "库存不足"),
    REPEATE_ERROR(500501, "该商品限购一件"),
    REQUEST_ILLEGAL(500502, "请求非法,请重新尝试"),
    ERROR_CAPTCHA(500503, "验证码错误，请重新输入"),
    ACCESS_LIMIT_REACHED(500504, "访问过于频繁，请稍后再试"),

    //订单模块5003xx
    ORDER_NOT_EXIST(500300, "订单不存在"),

    //注册模块5004xx
    USERNAME_EMPTY(500401, "用户名为空"),
    INFO_NOT_COMPLETE(500402, "信息不完整"),
    USER_EXIST(500403, "用户已存在"),


    //商品模块5005XX
    GOOD_EMPTY(500501, "商品类空"),
    SECKILL_GOOD_INSERT_ERROR(500502, "秒杀商品插入失败"),
    GOOD_INSERT_ERROR(500503, "商品插入失败"),

    //添加商品模块5006XX
    FILE_SIZE_OVER(500601, "图品超过10M了，请重新上传"),
    DATE_ERROR(500602, "时间范围不正确"),

    //添加商品模块5007XX
    IS_NOT_ADMIN(500701, "用户非管理员，无权限操作。"),
    ;

    private final Integer code;
    private final String message;
}
