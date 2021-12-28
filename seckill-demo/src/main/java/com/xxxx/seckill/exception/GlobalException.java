package com.xxxx.seckill.exception;

import com.xxxx.seckill.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @ClassName GlobalException
 * @Description 全局异常实体类
 * @Author 86137
 * @Date 2021-12-26 22:30
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException {
    private RespBeanEnum respBeanEnum;
}
