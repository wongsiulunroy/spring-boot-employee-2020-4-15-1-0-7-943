package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {
    private List<Company> companies = new ArrayList<>();

    public CompanyRepository() {
        List<Employee> ABCEmployeeList = new ArrayList<>();
        List<Employee> DEFEmployeeList = new ArrayList<>();
        companies.add(new Company(1, "ABC", 100, ABCEmployeeList));
        companies.add(new Company(2, "DEF", 10, DEFEmployeeList));
        ABCEmployeeList.add(new Employee(0, "Xiaoming", 20, "Male"));
        ABCEmployeeList.add(new Employee(1, "Xiaohong", 19, "Female"));
        ABCEmployeeList.add(new Employee(2, "Xiaozhi", 15, "Male"));
        DEFEmployeeList.add(new Employee(3, "Xiaogang", 16, "Male"));
        DEFEmployeeList.add(new Employee(4, "Xiaoxia", 16, "Female"));
    }

    public List<Company> getAllCompanies() {
        return companies;
    }

    public Company getCompanyById(int companyID) {
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                return company;
            }
        }
        return null;
    }

    public List<Employee> getEmployeeByCompanyId(int companyID) {
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                return company.getEmployeeList();
            }
        }
        return null;
    }
    
}
