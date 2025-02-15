package com.hande.jobfindapp.controller;

import com.hande.jobfindapp.model.CompanyProfile;
import com.hande.jobfindapp.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 * 15/02/2025
 * handebarkan
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/company")
    public List<CompanyProfile> findAll() {

        return companyService.returnAllCompanies();
    }

    @GetMapping("/company/{id}")
    public Optional<CompanyProfile> findById(@PathVariable Long id) {

        return companyService.returnCompanyById(id);
    }

    @PostMapping("/company")
    public CompanyProfile saveJob(@RequestBody CompanyProfile company) {
        return companyService.saveCompany(company);
    }

    @DeleteMapping("/company/{id}")
    public void deleteJobById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
    }

    @PutMapping("/company")
    public CompanyProfile updateJob(@RequestBody CompanyProfile company) {
        return companyService.updateCompany(company);
    }


}
