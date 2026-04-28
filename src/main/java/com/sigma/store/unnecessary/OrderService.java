package com.sigma.store.unnecessary;

import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class OrderService {

    private PaymentService paymentService;

    public OrderService() {

    }

    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }

//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
}
