package com.hande.jobfindapp.service;

import com.hande.jobfindapp.model.JobPost;
import com.hande.jobfindapp.model.UserPrincipal;
import com.hande.jobfindapp.model.UserProfile;
import com.hande.jobfindapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);


    @Override
    public List<UserProfile> returnAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserProfile returnUserById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public UserProfile saveUser(UserProfile user) {

        return userRepo.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserProfile updateUser(UserProfile user) {

        return userRepo.save(user);
    }

    /*@Override
    public void loadUsers() {
        List<UserProfile> users = new ArrayList<>(List.of(
                UserProfile.builder()
                        .id(1L)
                        .username("john_doe")
                        .password(encoder.encode("a@123"))
                        .firstName("John")
                        .lastName("Doe")
                        .email("john.doe@example.com")
                        .phoneNumber("1234567890")
                        .profession("Software Engineer")
                        .city("New York")
                        .build(),

                UserProfile.builder()
                        .username("jane_doe")
                        .password(encoder.encode("b@456"))
                        .firstName("Jane")
                        .lastName("Doe")
                        .email("jane.doe@example.com")
                        .phoneNumber("0987654321")
                        .profession("Data Scientist")
                        .city("San Francisco")
                        .build()
        ));

        userRepo.saveAll(users);
    }*/
}
