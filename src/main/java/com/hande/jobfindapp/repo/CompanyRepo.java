package com.hande.jobfindapp.repo;

import com.hande.jobfindapp.model.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * 15/02/2025
 * handebarkan
 */
@Repository
public interface CompanyRepo extends JpaRepository<CompanyProfile, Long> {
}
