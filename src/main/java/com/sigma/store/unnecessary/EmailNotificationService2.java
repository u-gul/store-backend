package com.sigma.store.unnecessary;

import org.springframework.beans.factory.annotation.Value;

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
