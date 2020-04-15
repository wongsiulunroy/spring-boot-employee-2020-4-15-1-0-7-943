package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        employees.add(new Employee(0,"Xiaoming",20,"Male"));
        employees.add(new Employee(1,"Xiaohong",19,"Female"));
        employees.add(new Employee(2,"Xiaozhi",15,"Male"));
        employees.add(new Employee(3,"Xiaogang",16,"Male"));
        employees.add(new Employee(4,"Xiaoxia",16,"Female"));
        return employees;
    }

    @GetMapping("/employeeID")
    @ResponseStatus(HttpStatus.OK)
    public Employee getAnEmployee(int employeeID) {
        return (Employee) employees.stream().filter(employee -> employee.getEmployeeID().equals(employeeID));
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }




}
