package com.xxxx.seckill.exception;

import com.xxxx.seckill.vo.RespBean;
import com.xxxx.seckill.vo.RespBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理类
 * @Author 86137
 * @Date 2021-12-26 22:31
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //@ExceptionHandler后面跟的是异常类
    @ExceptionHandler(Exception.class)
    public RespBean ExceptionHandler(Exception e){
        //如果这个异常属于我们定义的全局异常的话
        if(e instanceof GlobalException){
            GlobalException ex = (GlobalException) e;
            return RespBean.error(ex.getRespBeanEnum());
        }
        else if(e instanceof BindException){
            BindException ex = (BindException) e;
            RespBean respBean = RespBean.error(RespBeanEnum.BIND_ERROR);
            respBean.setMessage("参数校验异常：" + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }
}
