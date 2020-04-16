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
}
