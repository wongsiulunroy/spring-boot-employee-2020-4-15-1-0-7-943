package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repository;

    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    public Company getCompanyById(Integer companyID) {
        return repository.findById(companyID).orElse(null);
    }

    public List<Employee> getEmployeeByCompanyId(Integer companyID) {
        if (repository.findById(companyID) == null) {
            return null;
        } else {
            return repository.findById(companyID).get().getEmployeeList();
        }
    }

    public Company createNewCompany(Company company) {
        return repository.save(company);
    }

    public Company updateNewCompany(Integer companyID, Company newCompany) {
        List<Company> companies = getAllCompanies();
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                company.setCompanyID(newCompany.getCompanyID());
                company.setCompanyName(newCompany.getCompanyName());
                company.setEmployeeNumber(newCompany.getEmployeeNumber());
                company.setEmployeeList(newCompany.getEmployeeList());
            }
        }

        return repository.save(newCompany);
    }

    public void deleteAllEmployeeFromCompany(Integer companyID) {
        repository.deleteById(companyID);
    }
}
