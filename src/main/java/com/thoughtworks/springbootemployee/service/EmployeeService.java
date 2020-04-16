package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    public Employee getEmployeeById(int employeeID) {
        return repository.getEmployeeById(employeeID);
    }

    public List<Employee> getEmployeeByGender(String gender) {
        return repository.getEmployeeByGender(gender);
    }

    public Employee createNewEmployee(Employee employee) {
        return repository.createNewEmployee(employee);
    }

    public Employee updateNewEmployee(int employeeID, Employee newEmployee) {
        List<Employee> employees = getAllEmployees();
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                employee.setEmployeeID(newEmployee.getEmployeeID());
                employee.setEmployeeName(newEmployee.getEmployeeName());
                employee.setGender(newEmployee.getGender());
                employee.setAge(newEmployee.getAge());
            }
        }
        return repository.updateNewEmployee(employeeID, newEmployee);
    }

    public void deleteEmployee(int employeeID) {
        repository.deleteEmployee(employeeID);
    }
}
