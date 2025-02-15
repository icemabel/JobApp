package com.hande.jobfindapp.service;

import com.hande.jobfindapp.model.CompanyProfile;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<CompanyProfile> returnAllCompanies();

    Optional<CompanyProfile> returnCompanyById(long id);

    CompanyProfile saveCompany(CompanyProfile company);

    void deleteCompanyById(long id);

    CompanyProfile updateCompany(CompanyProfile company);

}
