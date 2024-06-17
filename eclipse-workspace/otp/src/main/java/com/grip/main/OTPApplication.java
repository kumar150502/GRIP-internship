package com.grip.main;

import java.util.Scanner;

public class OTPApplication {

    public static void main(String[] args) {
        String phoneNumber = "YOUR_PHONE_NUMBER";

        String otp = OTPValidator.generateAndStoreOTP(phoneNumber);
        System.out.println("Generated OTP: " + otp); 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the OTP you received:");
        String enteredOtp = scanner.nextLine();

        boolean isValid = OTPValidator.validateOTP(phoneNumber, enteredOtp);
        if (isValid) {
            System.out.println("OTP validated successfully.");
        } else {
            System.out.println("OTP validation failed.");
        }

        scanner.close();
    }
}