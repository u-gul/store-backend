package com.sigma.store;

public interface UserRepository {
    void save(User user);
    void getAllUsers();
}
