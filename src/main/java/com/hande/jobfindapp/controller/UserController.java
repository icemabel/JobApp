package com.hande.jobfindapp.controller;

import com.hande.jobfindapp.model.UserProfile;
import com.hande.jobfindapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserProfile> findAll() {
        return userService.returnAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserProfile findById(@PathVariable Long id) {
        return userService.returnUserById(id);
    }

    @PostMapping("/users")
    public UserProfile saveUser(UserProfile userProfile) {
        return userService.saveUser(userProfile);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/users")
    public UserProfile updateUser(UserProfile userProfile) {
        return userService.updateUser(userProfile);
    }

    @PostMapping("/register")
    public UserProfile registerUser(@RequestBody UserProfile userProfile) {
        return userProfile;
    }
}
