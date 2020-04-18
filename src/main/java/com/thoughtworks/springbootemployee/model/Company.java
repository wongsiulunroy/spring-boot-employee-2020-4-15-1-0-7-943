package com.thoughtworks.springbootemployee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyID;
    private String companyName;
    private Integer employeeNumber;

    @OneToMany(targetEntity = Employee.class, mappedBy = "companyID", fetch = FetchType.EAGER)
    private List<Employee> EmployeeList;

    public List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        for (int index = 0; index < EmployeeList.size(); index++) {
            employees.add(this.EmployeeList.get(index));
        }
        return employees;
    }

}
