package com.sigma.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@Service
public class EmailNotificationService2 implements NotificationService2{

    @Value("${email.host}")
    private String emailHost;

    @Value("${email.port}")
    private int emailPort;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Host: " + emailHost);
        System.out.println("Port: " + emailPort);
        System.out.println("Email: " + recipientEmail);
        System.out.println("Email Notification: " + message);
    }
}
