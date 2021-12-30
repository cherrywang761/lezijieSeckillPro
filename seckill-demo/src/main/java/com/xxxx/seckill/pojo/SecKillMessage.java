package com.xxxx.seckill.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: com.seckillpro.seckill_pro.pojo
 * @ClassName: SecKillMessage
 * @Author: lyx
 * @CreateTime: 2021/4/8 13:08
 * @Description: 秒杀信息
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecKillMessage {

    private User user;
    private Long goodId;
}
