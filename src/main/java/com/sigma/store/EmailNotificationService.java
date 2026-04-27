package com.sigma.store;

public class EmailNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("Email Notification " + message);
    }
}
