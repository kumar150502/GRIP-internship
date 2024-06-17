package com.grip.main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OTPValidator {

    private static final int OTP_VALIDITY_DURATION = 5;
    private static Map<String, OTPStorage> otpStorage = new HashMap<>();

    public static String generateAndStoreOTP(String phoneNumber) {
        String otp = OTPGenerator.generateOTP();
        storeOTP(phoneNumber, otp);
        return otp;
    }

    public static void storeOTP(String phoneNumber, String otp) {
        long expirationTime = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(OTP_VALIDITY_DURATION);
        otpStorage.put(phoneNumber, new OTPStorage(otp, expirationTime));
       
        SMSService.sendSMS(phoneNumber, otp);
    }

    public static boolean validateOTP(String phoneNumber, String otp) {
        OTPStorage otpDetails = otpStorage.get(phoneNumber);
        if (otpDetails == null) {
            return false; 
        }
        if (System.currentTimeMillis() > otpDetails.getExpirationTime()) {
            otpStorage.remove(phoneNumber);
            return false; 
        }
        if (!otp.equals(otpDetails.getOtp())) {
            return false; 
        }
        otpStorage.remove(phoneNumber); 
        return true;
    }
}