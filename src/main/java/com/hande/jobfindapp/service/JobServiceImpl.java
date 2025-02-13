package com.hande.jobfindapp.service;

import com.hande.jobfindapp.model.JobPost;
import com.hande.jobfindapp.repo.JobRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepo jobRepo;

    @Override
    public List<JobPost> returnAllJobPosts() {
        return jobRepo.findAll();
    }

    @Override
    public JobPost returnJobPostById(long id) {
        return jobRepo.findById(id).orElse(null);
    }

    @Override
    public JobPost saveJobPost(JobPost jobPost) {
        return jobRepo.save(jobPost);
    }

    @Override
    public void deleteJobPostById(long id) {
        jobRepo.deleteById(id);
    }

    @Override
    public JobPost updateJobPost(JobPost jobPost) {
        return null;
    }
}
