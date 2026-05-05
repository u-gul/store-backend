package com.sigma.store.services;

import com.sigma.store.dtos.ProductSummary;
import com.sigma.store.entities.Category;
import com.sigma.store.entities.Product;
import com.sigma.store.repositories.ProductRepository;
import com.sigma.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

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

    public void countProducts(BigDecimal min, BigDecimal max) {
        System.out.println(productRepository.countProducts(min, max));
    }

    @Transactional
    public void updatePrice(BigDecimal newPrice, Byte categoryId) {
        productRepository.updatePriceByCategory(newPrice, categoryId);
    }

    public void fetchProducts(Category category) {
        var products = productRepository.findProductsCategory(category);
//        for(int i = 0; i < products.size(); i++) {
//            System.out.println(products.get(i));
//        }

//        for(var product: products) {
//            System.out.println(product);
//        }

        products.forEach(System.out::println);
//        products.forEach(product -> System.out.println(product));
    }


    public void fetchUser(String email) {
        var user = userRepository.findByEmail(email).orElseThrow();
        System.out.println(user);
        System.out.println(user.getTags());
    }
}
