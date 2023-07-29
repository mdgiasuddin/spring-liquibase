package com.example.springliquibasee.config.redis.otp;

import com.example.springliquibasee.config.redis.RedisStorage;

import java.util.Objects;

public class OTPCacheManagerImpl implements OTPCacheManager {

    RedisStorage storage;

    public OTPCacheManagerImpl(RedisStorage storage) {
        this.storage = storage;
    }

    @Override
    public void storeOTP(String key, String otp) {
        storage.set(OTP_PREFIX + "::" + key, otp);
    }

    @Override
    public String getOTP(String key) {
        return storage.get(OTP_PREFIX + "::" + key, String.class);
    }

    @Override
    public void evictOTPCache(String key) {
        storage.evictCache(OTP_PREFIX + "::" + key);
    }

    @Override
    public boolean existsOTP(String key) {
        return !Objects.isNull(getOTP(key));
    }
}
