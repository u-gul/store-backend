package com.sigma.store;

public class SMSNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("SMS Notification " + message);
    }
}
