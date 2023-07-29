package com.example.springliquibasee.config.redis;

import org.springframework.cache.Cache;

import java.io.Serializable;

public class RedisStorageImpl implements RedisStorage {

    private final Cache cache;

    public RedisStorageImpl(Cache cache) {
        this.cache = cache;
    }

    @Override
    public void set(String key, Serializable value) {
        this.cache.put(key, value);
    }

    @Override
    public <T extends Serializable> T get(String key, Class<T> toValueType) {
        return this.cache.get(key, toValueType);
    }

    @Override
    public void evictCache(String key) {
        this.cache.evict(key);
    }
}
