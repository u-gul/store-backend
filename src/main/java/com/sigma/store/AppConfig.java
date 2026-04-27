package com.sigma.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // This ann tells spring to look here for the beans definitions
public class AppConfig {

    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(stripe());
    }
}
