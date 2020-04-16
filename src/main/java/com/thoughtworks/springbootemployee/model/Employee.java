package com.thoughtworks.springbootemployee.model;

public class Employee {
    private int employeeID;
    private String employeeName;
    private int age;
    private String gender;

    public Employee() {
    }

    public Employee(int employeeID, String employeeName, int age, String gender) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
