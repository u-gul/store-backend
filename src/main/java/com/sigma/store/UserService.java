package com.sigma.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

//@Service
public class UserService {

    private final UserRepository userRepository;

    private final NotificationService2 notificationService2;

    @Autowired
    public UserService(UserRepository userRepository, NotificationService2 notificationService2) {
        this.userRepository = userRepository;
        this.notificationService2 = notificationService2;
    }

    public void registerUser(User user) {
        userRepository.save(user);
        notificationService2.send("User is saved successfully", user.email());
    }

    public void getAllUsers() {
        userRepository.getAllUsers();
    }
}
