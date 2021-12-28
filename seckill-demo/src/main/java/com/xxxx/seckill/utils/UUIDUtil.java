package com.xxxx.seckill.utils;

import java.util.UUID;

/**
 * @Package: com.SecKillpro.SecKill_pro.utils
 * @ClassName: UUIdUtil
 * @Author: lyx
 * @CreateTime: 2021/3/3 17:58
 * @Description:
 */

public class UUIDUtil {
    public static String uuid() {
        //把UUID中的- 替换掉
        return UUID.randomUUID().toString().replace("-", "");
    }
}

