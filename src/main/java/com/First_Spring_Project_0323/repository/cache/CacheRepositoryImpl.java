package com.First_Spring_Project_0323.repository.cache;

import com.First_Spring_Project_0323.redis.RedisDetailsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPooled;

@Repository
public class CacheRepositoryImpl implements CacheRepository{

    @Autowired
    private JedisPooled jedisPooled;
    @Autowired
    private RedisDetailsConfig redisDetailsConfig;
    @Override
    public void createCacheEntity(String key, String value) {
        jedisPooled.setex(key,redisDetailsConfig.getTtl(),value);
    }

    @Override
    public String getCacheEntity(String key) {
        return jedisPooled.get(key);
    }

    @Override
    public void updateCacheEntity(String key, String value) {
        if(isKeyExist(key)){
            jedisPooled.setex(key,redisDetailsConfig.getTtl(),value);
        }
    }

    @Override
    public void deleteCacheEntity(String key) {
        if(isKeyExist(key)){
            jedisPooled.del(key);
        }
    }

    @Override
    public Boolean isKeyExist(String key) {
        return jedisPooled.exists(key);
    }
}
