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

    public EmployeeController(List<Employee> employees) {
        this.employees = employees;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        employees.add(new Employee(0, "Xiaoming", 20, "Male"));
        employees.add(new Employee(1, "Xiaohong", 19, "Female"));
        employees.add(new Employee(2, "Xiaozhi", 15, "Male"));
        employees.add(new Employee(3, "Xiaogang", 16, "Male"));
        employees.add(new Employee(4, "Xiaoxia", 16, "Female"));
        return employees;
    }

    @GetMapping("/{employeeID}")
    public Employee getAnEmployee(@PathVariable int employeeID) {
        employees.add(new Employee(0, "Xiaoming", 20, "Male"));
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }
        }
        return null;
    }
/*
    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeWithPageQuery(@RequestParam(defaultValue = "employees") int page, int pageSize) {
        employees.add(new Employee(0, "Xiaoming", 20, "Male"));
        employees.add(new Employee(1, "Xiaohong", 19, "Female"));
        employees.add(new Employee(2, "Xiaozhi", 15, "Male"));
        employees.add(new Employee(3, "Xiaogang", 16, "Male"));
        employees.add(new Employee(4, "Xiaoxia", 16, "Female"));
        return employees;
    }*/

    @GetMapping(params = "gender")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getMaleEmployee(@RequestParam(required = false) String gender) {
        List<Employee> MaleEmployee = new ArrayList<>();
        employees.add(new Employee(1, "Xiaohong", 19, "Female"));
        employees.add(new Employee(2, "Xiaozhi", 15, "Male"));
        employees.add(new Employee(3, "Xiaogang", 16, "Male"));
        employees.add(new Employee(4, "Xiaoxia", 16, "Female"));
        for (Employee employee : employees) {
            if (employee.getGender().equals(gender)) {
                MaleEmployee.add(employee);
            }
        }
        return MaleEmployee;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createNewEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    @PutMapping("/{employeeId}")
    public Employee updateNewEmployee(@PathVariable int employeeID, @RequestParam String employeeName, int age, String gender ) {
        Employee newEmployee = new Employee(employeeID, employeeName, age, gender);
        employees.add(newEmployee);
        return newEmployee;
    }

    @DeleteMapping("/{employeeId}")
    public void deleteNewEmployee(@PathVariable int employeeID) {
        employees.remove(employeeID);
        //return employee;
    }


}
