package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
        employees.add(new Employee(0, "Xiaoming", 20, "Male"));
        employees.add(new Employee(1, "Xiaohong", 19, "Female"));
        employees.add(new Employee(2, "Xiaozhi", 15, "Male"));
        employees.add(new Employee(3, "Xiaogang", 16, "Male"));
        employees.add(new Employee(4, "Xiaoxia", 16, "Female"));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int employeeID) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getEmployeeByGender(String gender) {
        List<Employee> selectedEmployee = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getGender().equals(gender)) {
                selectedEmployee.add(employee);
            }
        }
        return selectedEmployee;
    }

    public Employee createNewEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee updateNewEmployee(int employeeID, Employee newEmployee) {
        return newEmployee;
    }

    public void deleteEmployee(int employeeID) {
        employees.remove(employeeID);
    }
}
