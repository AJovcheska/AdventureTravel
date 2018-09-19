package com.finki.AdventureTravel.repository;

import com.finki.AdventureTravel.model.User;

import java.util.List;

public interface UserRepository {

    void addUser(User user);

    List<User> findAll();

    User findByEmail(String email);
}
