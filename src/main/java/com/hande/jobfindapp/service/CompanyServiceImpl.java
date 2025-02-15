package com.hande.jobfindapp.service;

import com.hande.jobfindapp.model.CompanyProfile;
import com.hande.jobfindapp.repo.CompanyRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * 15/02/2025
 * handebarkan
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepo companyRepo;

    @Override
    public List<CompanyProfile> returnAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public Optional<CompanyProfile> returnCompanyById(long id) {
        return companyRepo.findById(id);
    }

    @Override
    public CompanyProfile saveCompany(CompanyProfile company) {
        return companyRepo.save(company);
    }

    @Override
    public void deleteCompanyById(long id) {
        companyRepo.deleteById(id);
    }

    @Override
    public CompanyProfile updateCompany(CompanyProfile company) {
        return companyRepo.save(company);
    }
}
