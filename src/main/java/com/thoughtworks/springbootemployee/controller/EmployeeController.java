package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    private List<Employee> employees = new ArrayList<>();

    public EmployeeController(List<Employee> employees) {
        this.employees = employees;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/{employeeID}")
    public Optional<Employee> getEmployeeById(@PathVariable int employeeID) {
        return service.getEmployeeById(employeeID);
    }

    @GetMapping(params = "gender")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByGender(@RequestParam(required = false) String gender) {
        return service.getEmployeeByGender(gender);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createNewEmployee(@RequestBody Employee employee) {
        return service.createNewEmployee(employee);
    }

    @PutMapping("/{employeeID}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee updateNewEmployee(@PathVariable int employeeID, @RequestBody Employee newEmployee) {
        return service.updateNewEmployee(employeeID, newEmployee);
    }

    @DeleteMapping("/{employeeID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int employeeID) {
        service.deleteEmployee(employeeID);
    }


}
