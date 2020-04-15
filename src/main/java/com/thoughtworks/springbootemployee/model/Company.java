package com.thoughtworks.springbootemployee.model;

public class Company {
    private int companyID;
    private String companyName;
    private int employeeNumber;

    public Company(int companyID, String companyName, int employeeNumber) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.employeeNumber = employeeNumber;
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
}
