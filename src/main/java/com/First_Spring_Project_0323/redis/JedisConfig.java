package com.First_Spring_Project_0323.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
public class JedisConfig {

    @Autowired
    private RedisDetailsConfig redisDetailsConfig;

    @Bean
    public JedisPooled initiateJedis(){
        return new JedisPooled(redisDetailsConfig.getHost(), redisDetailsConfig.getPort());
    }
}
