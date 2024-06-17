package com.grip.main;

public class OTPStorage {
    private String otp;
    private long expirationTime;

    public OTPStorage(String otp, long expirationTime) {
        this.otp = otp;
        this.expirationTime = expirationTime;
    }

    public String getOtp() {
        return otp;
    }

    public long getExpirationTime() {
        return expirationTime;
    }
}