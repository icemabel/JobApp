package com.hande.jobfindapp.repo;

import com.hande.jobfindapp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<JobPost, Long> {

}
