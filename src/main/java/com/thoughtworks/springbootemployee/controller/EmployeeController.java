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

    @GetMapping//(value = "", params = {"page", "pageSize"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees(){//@RequestParam(required = false) int page, @RequestParam(required = false) int pageSize) {
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
        employees.add(new Employee(1, "Xiaohong", 19, "Female"));
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }
        }
        return null;
    }

    @GetMapping(params = "gender")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByGender(@RequestParam(required = false) String gender) {
        List<Employee> selectedEmployee = new ArrayList<>();
        //employees.add(new Employee(1, "Xiaohong", 19, "Female"));
        //employees.add(new Employee(2, "Xiaozhi", 15, "Male"));
        //employees.add(new Employee(3, "Xiaogang", 16, "Male"));
        //employees.add(new Employee(4, "Xiaoxia", 16, "Female"));
        for (Employee employee : employees) {
            if (employee.getGender().equals(gender)) {
                selectedEmployee.add(employee);
            }
        }
        return selectedEmployee;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createNewEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    @PutMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee updateNewEmployee(@PathVariable int employeeID, @RequestBody Employee newEmployee) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                employee.setEmployeeID(newEmployee.getEmployeeID());
                employee.setEmployeeName(newEmployee.getEmployeeName());
                employee.setGender(newEmployee.getGender());
                employee.setAge(newEmployee.getAge());
            }
        }
        return newEmployee;
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNewEmployee(@PathVariable int employeeID) {
        employees.remove(employeeID);
    }


}
