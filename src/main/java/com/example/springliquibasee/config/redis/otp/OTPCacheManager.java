package com.example.springliquibasee.config.redis.otp;

public interface OTPCacheManager {

    String OTP_PREFIX = "OTP";

    void storeOTP(String key, String otp);

    String getOTP(String key);

    void evictOTPCache(String key);

    boolean existsOTP(String key);

}

