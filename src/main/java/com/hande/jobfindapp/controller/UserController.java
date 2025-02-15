package com.hande.jobfindapp.controller;

import com.hande.jobfindapp.model.UserProfile;
import com.hande.jobfindapp.service.JwtService;
import com.hande.jobfindapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    @GetMapping("/users")
    public List<UserProfile> findAll() {
        return userService.returnAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserProfile findById(@PathVariable Long id) {
        return userService.returnUserById(id);
    }

    @PostMapping("/users")
    public UserProfile saveUser(@RequestBody UserProfile userProfile) {
        return userService.saveUser(userProfile);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/users")
    public UserProfile updateUser(@RequestBody UserProfile userProfile) {
        return userService.updateUser(userProfile);
    }

    @PostMapping("/register")
    public UserProfile registerUser(@RequestBody UserProfile userProfile) {
        return userProfile;
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserProfile userProfile) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userProfile.getUsername(), userProfile.getPassword()));

        if (authentication.isAuthenticated())
            return jwtService.generateToken(userProfile.getUsername());
        else
            return "Login Failed";
    }


}
