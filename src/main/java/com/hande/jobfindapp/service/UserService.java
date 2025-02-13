package com.hande.jobfindapp.service;

import com.hande.jobfindapp.model.JobPost;
import com.hande.jobfindapp.model.UserProfile;

import java.util.List;

public interface UserService {
    List<UserProfile> returnAllUsers();

    UserProfile returnUserById(long id);
    UserProfile saveUser(UserProfile user);
    void deleteJobPostById(long id);
    UserProfile updateUser(UserProfile user);

    void loadUsers();
}
