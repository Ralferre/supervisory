package com.example.supervisory.api.controller.user;

import com.example.supervisory.api.model.user.User;
import com.example.supervisory.api.repository.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api-supervisory/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/name")
    public Page<User> getUsersByName(@RequestParam String name, Pageable pageable) {
        return userRepository.findByName(name, pageable);
    }

    @GetMapping("/user-name")
    public Page<User> getUsersByUserName(@RequestParam String userName, Pageable pageable) {
        return userRepository.findByUserName(userName, pageable);
    }

    @GetMapping("/profile")
    public Page<User> getUsersByProfile(@RequestParam String profile, Pageable pageable) {
        return userRepository.findByProfile(profile, pageable);
    }

    @GetMapping("/created-on")
    public Page<User> getUsersByCreatedOn(@RequestParam String createdOn, Pageable pageable) {
        return userRepository.findByCreatedOn(createdOn, pageable);
    }

    @PostMapping("/create-users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        user.setCreatedOn();
        User savedUser = userRepository.save(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
