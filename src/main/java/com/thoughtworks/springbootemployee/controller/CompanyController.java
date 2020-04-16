package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    List<Company> companies = new ArrayList<>();
    @Autowired
    private CompanyService service;

    public CompanyController(List<Company> companies) {
        this.companies = companies;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAllCompanies() {
        return service.getAllCompanies();
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
    public Company getCompanyById(@PathVariable int companyID) {
        return service.getCompanyById(companyID);
    }

    @GetMapping("/{companyID}/employees")
    public List<Employee> getEmployeeByCompanyId(@PathVariable int companyID) {
        return service.getEmployeeByCompanyId(companyID);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createNewCompany(@RequestBody Company company) {
        companies.add(company);
        return company;
    }

    @PutMapping("/{companyID}")
    public Company updateNewCompany(@PathVariable int companyID, @RequestBody Company newCompany) {
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                company.setCompanyID(newCompany.getCompanyID());
                company.setCompanyName(newCompany.getCompanyName());
                company.setEmployeeNumber(newCompany.getEmployeeNumber());
                company.setEmployeeList(newCompany.getEmployeeList());
            }
        }
        return newCompany;
    }

    @DeleteMapping("/{companyID}")
    public void deleteAllEmployeeFromCompany(@PathVariable int companyID) {
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                companies.remove(company);
            }
        }
    }


}
