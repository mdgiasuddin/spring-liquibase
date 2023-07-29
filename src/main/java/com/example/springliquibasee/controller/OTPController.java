package com.example.springliquibasee.controller;

import com.example.springliquibasee.dto.OTPRequest;
import com.example.springliquibasee.service.OTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
public class OTPController {

    private final OTPService otpService;

    @PostMapping
    public String saveOTP(@RequestBody OTPRequest request) {
        return otpService.saveOTP(request);
    }

    @GetMapping("/{phoneNumber}")
    public String getOTP(@PathVariable String phoneNumber) {
        return otpService.getOTP(phoneNumber);
    }
}
