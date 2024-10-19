package com.example.supervisory.api.service.user;

import com.example.supervisory.api.model.user.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findByUserName(String userName);
    Optional<User> findByName(String name);
    Optional<User> findByProfile(String profile);
    Optional<User> findByCreatedOn(String createdOn);
}
