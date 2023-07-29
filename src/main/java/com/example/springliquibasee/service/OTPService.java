package com.example.springliquibasee.service;

import com.example.springliquibasee.config.redis.otp.OTPCacheManager;
import com.example.springliquibasee.dto.OTPRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class OTPService {

    private final OTPCacheManager otpCacheManager;
    private final Random random = new Random();

    public String saveOTP(OTPRequest request) {
        String otp = String.valueOf(random.nextInt(100000));
        otpCacheManager.storeOTP(request.phoneNumber(), otp);

        return String.format("OTP: %s stored successfully!", otp);
    }

    public String getOTP(String phoneNumber) {
        String otp = otpCacheManager.getOTP(phoneNumber);
        if (otp == null) {
            return "OTP not found!";
        }

        return String.format("OTP: %s", otp);
    }

    public String deleteOTP(String phoneNumber) {
        otpCacheManager.evictOTPCache(phoneNumber);

        return "OTP deleted successfully!";
    }
}
