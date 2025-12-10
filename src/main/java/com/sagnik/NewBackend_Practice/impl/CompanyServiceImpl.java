package com.sagnik.NewBackend_Practice.impl;

import com.sagnik.NewBackend_Practice.Job.Job;
import com.sagnik.NewBackend_Practice.company.Company;
import com.sagnik.NewBackend_Practice.company.CompanyRepository;
import com.sagnik.NewBackend_Practice.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {
            Company companyToUpdate  = companyOptional.get();
            companyToUpdate.setId(companyToUpdate.getId());
            companyToUpdate.setDescription(companyToUpdate.getDescription());
            companyToUpdate.setName(companyToUpdate.getName());

            companyRepository.save(companyToUpdate);

            return true;
        }else{
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}


