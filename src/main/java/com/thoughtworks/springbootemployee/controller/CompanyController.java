package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @GetMapping("/{companyID}")
    public Company getCompanyById(@PathVariable Integer companyID) {
        return service.getCompanyById(companyID);
    }

    @GetMapping("/{companyID}/employees")
    public List<Employee> getEmployeeByCompanyId(@PathVariable Integer companyID) {
        return service.getEmployeeByCompanyId(companyID);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createNewCompany(@RequestBody Company company) {
        return service.createNewCompany(company);
    }

    @PutMapping("/{companyID}")
    public Company updateNewCompany(@PathVariable Integer companyID, @RequestBody Company newCompany) {
        return service.updateNewCompany(companyID, newCompany);
    }

    @DeleteMapping("/{companyId}")
    public void deleteAllEmployeeFromCompany(@PathVariable Integer companyID) {
        service.deleteAllEmployeeFromCompany(companyID);
    }


}
