package com.sigma.store.unnecessary;

import java.util.HashMap;
import java.util.Map;

//@Repository
public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        String email = user.email();
        users.putIfAbsent(email, user);
    }

    @Override
    public void getAllUsers() {
        System.out.println(users);
    }

    @Override
    public String toString() {
        return "InMemoryUserRepository{" +
                "users=" + users +
                '}';
    }
}
