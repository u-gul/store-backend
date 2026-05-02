package com.sigma.store.services;

import com.sigma.store.entities.Address;
import com.sigma.store.entities.Category;
import com.sigma.store.entities.Product;
import com.sigma.store.entities.User;
import com.sigma.store.repositories.AddressRepository;
import com.sigma.store.repositories.CategoryRepository;
import com.sigma.store.repositories.ProductRepository;
import com.sigma.store.repositories.ProfileRepository;
import com.sigma.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;


    @Transactional
    public void showEntityStates() {
        User user = User.builder()
                .name("Raju")
                .email("raju@sigma.com")
                .password("hello")
                .build();

        if(entityManager.contains(user)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient / Detached");
        }

        userRepository.save(user);

        if(entityManager.contains(user)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient / Detached");
        }
    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getBio());
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        Address address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated() {

//        var user = User.builder()
//                .name("Jonny")
//                .email("james@gmail.com")
//                .password("bond")
//                .build();

        var address = Address.builder()
                .street("Gandhi Nagar")
                .city("Himalya")
                .state("RJ")
                .zip("345678")
                .build();

        var user = userRepository.findById(7L).orElseThrow();
        user.addAddress(address);
        userRepository.save(user);
//        addressRepository.save(address);
    }

    public void fetchUserAndAddress() {
        System.out.println(userRepository.findById(5L).orElseThrow().getAddresses());
    }

    public void saveProduct() {
        Product product = Product.builder()
                .price(BigDecimal.valueOf(22.0))
                .description("Fashion Garment")
                .name("Taped Jeans")
                .build();

        Category category = new Category();
        category.setName("Jeans");
        category.getProducts().add(product);
        product.setCategory(category);
        categoryRepository.save(category);
    }

    @Transactional
    public void addProductToExistingCategory() {
        Category category = categoryRepository.findById((byte) 3).orElseThrow();

        Product product = Product.builder()
                .price(BigDecimal.valueOf(28.0))
                .description("Fast Fashion")
                .name("Fade Jeans")
                .build();

        category.getProducts().add(product);
        product.setCategory(category);
//        categoryRepository.save(category);
    }

    @Transactional
    public void manageProducts() {

        // var category = categoryRepository.findById((byte) 4).orElseThrow();

        // var product = Product.builder()
        //                 .name("Product2")
        //                 .description("Description2")
        //                 .price(BigDecimal.valueOf(12.99))
        //                 .category(category)
        //                 .build();

        // productRepository.save(product);

        var user = userRepository.findById(2L).orElseThrow();
        var products = productRepository.findAll();

        products.forEach(user::addFavoriteProduct);
        userRepository.save(user);
    }
}
