package com.sigma.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // This ann tells spring to look here for the beans definitions
public class AppConfig {

    @Value("${payment-gateway}")
    private String paymentGateway;

    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        return new PayPalPaymentService();
    }

    @Bean
    public OrderService orderService() {
        if(paymentGateway.equals("stripe")) {
            return new OrderService(stripe());
        }
        return new OrderService(paypal());
    }

    @Bean
    public NotificationService2 email2() {
        return new EmailNotificationService2();
    }

    @Bean
    public InMemoryUserRepository users() {
        return new InMemoryUserRepository();
    }

    @Bean
    public UserService userService() {
        return new UserService(users(), email2());
    }
}
