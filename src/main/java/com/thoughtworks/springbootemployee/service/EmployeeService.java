package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(int employeeID) {
        return repository.findById(employeeID);
    }

    public List<Employee> getEmployeeByGender(String gender) {
        return repository.findAllEmployeeByGender(gender);
    }

    public Employee createNewEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateNewEmployee(int employeeID, Employee newEmployee) {
        if (newEmployee == null){
            return null;
        }
        List<Employee> employees = getAllEmployees();
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                employee.setEmployeeID(newEmployee.getEmployeeID());
                employee.setEmployeeName(newEmployee.getEmployeeName());
                employee.setGender(newEmployee.getGender());
                employee.setAge(newEmployee.getAge());
            }
        }
        repository.save(newEmployee);
        return newEmployee;
    }

    public void deleteEmployee(int employeeID) {
        repository.deleteById(employeeID);
    }
}
