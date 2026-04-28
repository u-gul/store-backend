package com.sigma.store.unnecessary;

//@Service("paypal")
public class PayPalPaymentService implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal");
        System.out.println("Amount: " + amount + " paid.");
    }
}
