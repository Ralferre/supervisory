package com.example.supervisory.api.repository.user;

import com.example.supervisory.api.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public abstract interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByName(String name, Pageable pageable);
    Page<User> findByUserName(String userName, Pageable pageable);
    Page<User> findByProfile(String profile, Pageable pageable);
    Page<User> findByCreatedOn(String createdOn, Pageable pageable);
    Page<User> findAll(Pageable pageable);
}

