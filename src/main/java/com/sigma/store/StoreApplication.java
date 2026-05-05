package com.sigma.store;

import com.sigma.store.entities.Category;
import com.sigma.store.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var productService = context.getBean(ProductService.class);
        productService.fetchUser("gaurav@gmail.com");
    }
}
