package com.sigma.store;

public class OrderService {

    public void placeOrder() {
       StripePaymentService paymentService =  new StripePaymentService();
       paymentService.processPayment(10);
    }
}
