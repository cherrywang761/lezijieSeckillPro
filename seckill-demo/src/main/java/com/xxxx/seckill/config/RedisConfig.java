package com.xxxx.seckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ClassName RedisConfig
 * @Description redis配置类
 * @Author 86137
 * @Date 2021-12-28 23:31
 * @Version 1.0
 */
@Configuration
public class RedisConfig {
    //redis默认的是jdk的序列方法，但是序列方法是二进制的，
    //但是我们更喜欢从redis中拿数据的时候直接获取到准确值
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //设置key的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //同理设置value的序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        //对hash类型的序列化形式也做一个设置
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        //注入连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
