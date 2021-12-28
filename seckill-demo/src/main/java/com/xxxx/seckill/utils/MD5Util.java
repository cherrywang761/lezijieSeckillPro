package com.xxxx.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @ClassName MD5Util
 * @Description TODO
 * @Author 86137
 * @Date 2021-12-20 23:14
 * @Version 1.0
 */
@Component
public class MD5Util {


    private static final String salt = "1a2b3c4d"; //这个自定义

    public static String md5(String sac) {
        //commons-lang3  version:3.6
        String md5 = DigestUtils.md5Hex(sac);
        return md5;
    }

    /**
     * 第一次明文加固定salt加密
     *
     * @param inputPass
     * @return
     */
    public static String inputPassToFormPass(String inputPass) {
        String str = "" + salt.charAt(1) + salt.charAt(6) + inputPass + salt.charAt(2) + salt.charAt(3);
        return md5(str);
    }

    /**
     * 第二次加密md5的值+随机盐再进行md5加密
     *
     * @param formPass
     * @param salt
     * @return
     */
    public static String formPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(1) + salt.charAt(6) + formPass + salt.charAt(2) + salt.charAt(3);
        return md5(str);
    }

    /**
     * 整体加密
     */
    public static String inputPassToDbPass(String pass, String salt) {
        //第一次加密
        String onePass = inputPassToFormPass(pass);
        //第二次加密
        return formPassToDBPass(onePass, salt);

    }

    public static void main(String[] args) {

        System.out.println(inputPassToFormPass("123456"));
        System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));
        System.out.println(formPassToDBPass("d3cae5cc6c8cf5776fbd1fb351ec677e", "1a2b3c4d"));
    }

}
