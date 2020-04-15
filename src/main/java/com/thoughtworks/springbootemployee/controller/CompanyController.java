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

    public CompanyController(List<Company> companies) {
        this.companies = companies;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAllCompanies() {
        initCompanies();
        return companies;
    }

    private void initCompanies() {
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

    @GetMapping("/{companyID}")
    public Company getCompany(@PathVariable int companyID) {
        initCompanies();
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                return company;
            }
        }
        return null;
    }

    @GetMapping("/{companyID}/employees")
    public List<Employee> getEmployeeOfCompany(@PathVariable int companyID) {
        initCompanies();
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                return company.getEmployeeList();
            }
        }
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createNewCompany(@RequestBody Company company) {
        companies.add(company);
        return company;
    }

    @PutMapping("/{companyID}")
    public Company updateNewCompany(@PathVariable int companyID, @RequestParam String companyName, int employeeNumber, List<Employee> employees) {
        Company newCompany = new Company(companyID, companyName, employeeNumber, employees);
        companies.add(newCompany);
        return newCompany;
    }

    @DeleteMapping("/{companyID}")
    public void deleteAllEmployeeFromCompany(@PathVariable int companyID) {
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                company.getEmployeeList().clear();
            }
        }
    }


}
