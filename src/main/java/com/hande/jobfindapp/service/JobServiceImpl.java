package com.hande.jobfindapp.service;

import com.hande.jobfindapp.model.JobPost;
import com.hande.jobfindapp.repo.JobRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return jobRepo.save(jobPost);
    }

    @Override
    public void load() {
        List<JobPost> jobs =
                new ArrayList<>(List.of(
                        new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL","API")),
                        new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow","API")),
                        new JobPost(3, "Frontend Developer", "Create API amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS","API")),
                        new JobPost(4, "Network Engineer", "Design and API maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))
                ));
        jobRepo.saveAll(jobs);
    }
}
