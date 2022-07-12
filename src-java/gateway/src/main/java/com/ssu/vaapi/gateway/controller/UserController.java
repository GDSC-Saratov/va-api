package com.ssu.vaapi.gateway.controller;

import com.ssu.vaapi.persistence.entities.User;
import com.ssu.vaapi.persistence.repositories.UserRepository;
import com.ssu.vaapi.persistence.repositories.impl.UserRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserRepository repository = new UserRepositoryImpl();
    @PostMapping("/api/user")
    @ResponseStatus(HttpStatus.OK)
    public void registerUser(String username, String password) {
        repository.add(new User(username, password));
    }

    @GetMapping("/api/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public String getUser(@PathVariable long userId) {
        return String.format("Returning user with %s userId", userId);
    }
}
