package com.example.springliquibasee.config.redis;

import com.example.springliquibasee.config.redis.otp.OTPCacheManager;
import com.example.springliquibasee.config.redis.otp.OTPCacheManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.springliquibasee.config.redis.RedisConfig.OTP_DATA;

@Configuration
public class CacheManagerConfig {

    @Bean
    public OTPCacheManager otpCacheManager(@Autowired CacheManager cacheManager) {
        RedisStorage storage = new RedisStorageImpl(cacheManager.getCache(OTP_DATA));
        return new OTPCacheManagerImpl(storage);
    }
}
