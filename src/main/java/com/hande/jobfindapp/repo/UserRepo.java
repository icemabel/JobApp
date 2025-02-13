package com.hande.jobfindapp.repo;

import com.hande.jobfindapp.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserProfile, Long> {
}
