package com.hande.jobfindapp.service;

import com.hande.jobfindapp.model.JobPost;

import java.util.List;

public class JobServiceImpl implements JobService {
    @Override
    public List<JobPost> returnAllJobPosts() {
        return List.of();
    }

    @Override
    public JobPost returnJobPostById(long id) {
        return null;
    }

    @Override
    public JobPost saveJobPost(JobPost jobPost) {
        return null;
    }

    @Override
    public void deleteJobPostById(long id) {

    }

    @Override
    public JobPost updateJobPost(JobPost jobPost) {
        return null;
    }
}
