package com.sigma.store.unnecessary;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

//@Service("stripe")
//@Primary
public class StripePaymentService implements PaymentService {

    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private boolean isEnabled;

    @Value("${stripe.timeout:3000}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;

    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE");
        System.out.println("apiUrl: " + apiUrl);
        System.out.println("isEnabled: " + isEnabled);
        System.out.println("timeout: " + timeout);
        System.out.println("supportedCurrencies: " + supportedCurrencies);
        System.out.println("Amount: " + amount + " paid.");
    }
}
