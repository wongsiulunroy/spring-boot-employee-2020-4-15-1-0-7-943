package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        companies.add(new Company(1, "ABC", 100));
        companies.add(new Company(2, "DEF", 10));
        companies.add(new Company(3, "GH", 20));
        return companies;
    }

}
