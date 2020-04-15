package com.thoughtworks.springbootemployee.model;

import javax.el.ArrayELResolver;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private int companyID;
    private String companyName;
    private int employeeNumber;
    private List<Employee> EmployeeList;
;

    public Company(int companyID, String companyName, int employeeNumber, List<Employee> employeeList) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.employeeNumber = employeeNumber;
        EmployeeList = employeeList;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        for(int index = 0; index<EmployeeList.size(); index++) {
            employees.add(this.EmployeeList.get(index));
        }
        return employees;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        EmployeeList = employeeList;
    }
}
