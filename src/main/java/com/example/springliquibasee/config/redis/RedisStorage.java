package com.example.springliquibasee.config.redis;

import java.io.Serializable;

public interface RedisStorage {
    void set(String key, Serializable value);

    <T extends Serializable> T get(String key, Class<T> toValueType);

    void evictCache(String key);
}
