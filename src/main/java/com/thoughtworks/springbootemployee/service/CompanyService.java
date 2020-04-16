package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repository;

    public List<Company> getAllCompanies() {
        return repository.getAllCompanies();
    }

    public Company getCompanyById(int companyID) {
        return repository.getCompanyById(companyID);
    }

    public List<Employee> getEmployeeByCompanyId(int companyID) {
        return repository.getEmployeeByCompanyId(companyID);
    }

    public Company createNewCompany(Company company) {
        return repository.createNewCompany(company);
    }

    public Company updateNewCompany(int companyID, Company newCompany) {
        List<Company> companies = getAllCompanies();
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                company.setCompanyID(newCompany.getCompanyID());
                company.setCompanyName(newCompany.getCompanyName());
                company.setEmployeeNumber(newCompany.getEmployeeNumber());
                company.setEmployeeList(newCompany.getEmployeeList());
            }
        }
        return repository.updateNewCompany(companyID, newCompany);
    }

    public void deleteAllEmployeeFromCompany(int companyID) {
        repository.deleteAllEmployeeFromCompany(companyID);
    }
}
