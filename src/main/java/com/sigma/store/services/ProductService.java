package com.sigma.store.services;

import com.sigma.store.entities.Product;
import com.sigma.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void getProductsByName(String name) {
        List<Product> products = productRepository.findByName(name);
        for(Product product : products) {
            System.out.println(product);
        }
    }

    public void getProductBetweenPrice(BigDecimal min, BigDecimal max) {
        List<Product> products = productRepository.findProducts2(min, max);
        products.forEach(System.out::println);
    }
}
