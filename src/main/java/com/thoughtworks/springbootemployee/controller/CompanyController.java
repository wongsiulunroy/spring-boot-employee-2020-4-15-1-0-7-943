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

        companies.add(new Company(1, "ABC", 100));
        companies.add(new Company(2, "DEF", 10));
        companies.add(new Company(3, "GH", 20));
        return companies;
    }

    @GetMapping("/{companyID}")
    public Company getAnEmployee(@PathVariable int companyID) {
        companies.add(new Company(1, "ABC", 100));
        companies.add(new Company(2, "DEF", 10));
        for (Company company : companies) {
            if (company.getCompanyID() == companyID) {
                return company;
            }
        }
        return null;
    }

}
