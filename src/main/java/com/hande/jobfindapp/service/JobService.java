package com.hande.jobfindapp.service;

import com.hande.jobfindapp.model.JobPost;

import java.util.List;

public interface JobService {

    List<JobPost> returnAllJobPosts();

    JobPost returnJobPostById(long id);
    JobPost saveJobPost(JobPost jobPost);
    void deleteJobPostById(long id);
    JobPost updateJobPost(JobPost jobPost);

    void load();
}
