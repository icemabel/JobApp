package com.hande.jobfindapp.service;

import com.hande.jobfindapp.model.UserPrincipal;
import com.hande.jobfindapp.model.UserProfile;
import com.hande.jobfindapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserProfile> user = userRepo.findByUsername(username);

        if (user == null || !user.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user.get());
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public UserProfile saveUser(UserProfile user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
