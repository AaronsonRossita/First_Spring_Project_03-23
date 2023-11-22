package com.First_Spring_Project_0323.repository.cache;

public interface CacheRepository {

    void createCacheEntity(String key, String value);
    String getCacheEntity(String key);
    void updateCacheEntity(String key, String value);
    void deleteCacheEntity(String key);

    Boolean isKeyExist(String key);
}
