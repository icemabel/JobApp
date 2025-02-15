package com.hande.jobfindapp.controller;

import com.hande.jobfindapp.model.JobPost;
import com.hande.jobfindapp.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    private final JobService jobService;

    @GetMapping("/jobs")
    public List<JobPost> findAll() {
        return jobService.returnAllJobPosts();
    }

    @GetMapping("/jobs/{id}")
    public JobPost findById(@PathVariable Long id) {
        return jobService.returnJobPostById(id);
    }

    @PostMapping("/jobs")
    public JobPost saveJob(@RequestBody JobPost jobPost) {
        return jobService.saveJobPost(jobPost);
    }

    @DeleteMapping("/jobs/{id}")
    public void deleteJobById(@PathVariable Long id) {
        jobService.deleteJobPostById(id);
    }

    @PutMapping("/jobs")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        return jobService.updateJobPost(jobPost);
    }

    public String loadData(){
        jobService.load();
        return "success";
    }

    @GetMapping("/jobs/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return jobService.search(keyword);
    }
}
