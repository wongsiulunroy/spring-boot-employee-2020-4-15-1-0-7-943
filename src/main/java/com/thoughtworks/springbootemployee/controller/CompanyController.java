package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    List<Company> companies = new ArrayList<>();
    List<Employee> tempEmployeeList = new ArrayList<>();

    public CompanyController(List<Company> companies) {
        this.companies = companies;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAllCompanies() {
        companies.add(new Company(1, "ABC", 100, tempEmployeeList));
        companies.add(new Company(2, "DEF", 10, tempEmployeeList));
        companies.add(new Company(3, "GH", 20, tempEmployeeList));
        return companies;
    }

    @GetMapping("/{companyID}")
    public Company getCompany(@PathVariable int companyID) {
        companies.add(new Company(1, "ABC", 100, tempEmployeeList));
        companies.add(new Company(2, "DEF", 10, tempEmployeeList));
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                return company;
            }
        }
        return null;
    }

    @GetMapping("/{companyID}/employees")
    public List<Employee> getEmployeeOfCompany(@PathVariable int companyID) {
        List<Employee> ABCEmployeeList = new ArrayList<>();
        List<Employee> DEFEmployeeList = new ArrayList<>();
        companies.add(new Company(1, "ABC", 100, ABCEmployeeList));
        companies.add(new Company(2, "DEF", 10, DEFEmployeeList));
        ABCEmployeeList.add(new Employee(0, "Xiaoming", 20, "Male"));
        ABCEmployeeList.add(new Employee(1, "Xiaohong", 19, "Female"));
        ABCEmployeeList.add(new Employee(2, "Xiaozhi", 15, "Male"));
        DEFEmployeeList.add(new Employee(3, "Xiaogang", 16, "Male"));
        DEFEmployeeList.add(new Employee(4, "Xiaoxia", 16, "Female"));
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                return company.getEmployeeList();
            }
        }
        return null;
    }



}
