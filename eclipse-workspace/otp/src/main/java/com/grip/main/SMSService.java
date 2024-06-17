package com.grip.main;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;

public class SMSService {
    private static final String NEXMO_API_KEY = "16e2289d";
    private static final String NEXMO_API_SECRET = "FDOK866dgMBzHhGX";
    private static final String NEXMO_FROM_NUMBER = "8688813746";
    
    public static void sendSMS(String toPhoneNumber, String otp) {
        NexmoClient client = new NexmoClient.Builder()
                .apiKey(NEXMO_API_KEY)
                .apiSecret(NEXMO_API_SECRET)
                .build();

        TextMessage message = new TextMessage(NEXMO_FROM_NUMBER, toPhoneNumber,
                "Your OTP is: " + otp + ". This OTP is valid for 5 minutes.");

        try {
            SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

            if (response != null) {
                System.out.println("SMS sent to " + toPhoneNumber + ". Status: " + response.getMessages().get(0).getStatus());
            } else {
                System.out.println("No response received from Nexmo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}