package com.xxxx.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: com.SecKillpro.SecKill_pro.vo
 * @ClassName: RespBean
 * @Author: lyx
 * @CreateTime: 2021/3/3 11:15
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功的返回结果
     *
     * @return
     */
    public static RespBean success() {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 成功的返回结果
     *
     * @param obj
     * @return
     */
    public static RespBean success(Object obj) {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBean.success().getMessage(), obj);
    }

    /**
     * 失败的返回结果
     *
     * @param respBeanEnum
     * @return
     */
    public static RespBean error(RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), null);
    }

    /**
     * 失败的返回结果
     *
     * @param respBeanEnum
     * @param obj
     * @return
     */
    public static RespBean error(RespBeanEnum respBeanEnum, Object obj) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), obj);
    }
}
