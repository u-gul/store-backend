package com.sigma.store.services;

import com.sigma.store.entities.User;
import com.sigma.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;


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


}
