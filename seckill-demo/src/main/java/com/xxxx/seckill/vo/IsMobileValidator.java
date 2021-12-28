package com.xxxx.seckill.vo;

import com.xxxx.seckill.utils.ValidatorUtil;
import com.xxxx.seckill.validator.IsMobile;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName isMobileValidator
 * @Description 手机号码校验规则
 * @Author 86137
 * @Date 2021-12-23 23:39
 * @Version 1.0
 */
//自定义注解的校验规则类要通过ConstraintValidator接口去绑定相关的校验注解， String是表示注解后面跟的参数类型为String
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    //多个方法都会用到这个属性，所以抽取成全局变量
    private boolean required = false;

    //初始化,对全局变量赋值
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //必需
        if(required){
            return ValidatorUtil.isMobile(value);
        }else{
            //不是必需
            //没传值就不用校验直接返回true
            if(StringUtils.isEmpty(value)){
                return true;
            }else{
                //传了值就校验下
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
