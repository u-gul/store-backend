package com.sigma.store;

import com.sigma.store.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var productService = context.getBean(ProductService.class);
        productService.getProductBetweenPrice(BigDecimal.valueOf(2.00), BigDecimal.valueOf(9.99));
    }
}
