package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.controller.EmployeeController;
import com.thoughtworks.springbootemployee.model.Employee;
import io.restassured.http.ContentType;
import io.restassured.mapper.TypeRef;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(employeeController);
    }

    @Test
    public void shouldFindEmployeeById() {
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .when()
                .get("/employees/1");

        Assert.assertEquals(200, response.getStatusCode());
        Employee employee = response.getBody().as(Employee.class);
        Assert.assertEquals(java.util.Optional.of(1), employee.getEmployeeID());
        Assert.assertEquals("Xiaohong", employee.getEmployeeName());
    }

    @Test
    public void shouldFindEmployeeByGender() {
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .params("gender","Male")
                .when()
                .get("/employees");

        Assert.assertEquals(200, response.getStatusCode());
        List<Employee> employees = response.getBody().as(new TypeRef<List<Employee>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        Assert.assertEquals(3, employees.size());
        Assert.assertEquals("Xiaoming", employees.get(0).getEmployeeName());
    }

    @Test
    public void shouldAddEmployee() {
        Employee employee = new Employee(100,"Tom", 10, "Male", 1);
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .body(employee)
                .when()
                .post("/employees");

        Assert.assertEquals(201, response.getStatusCode());
        Assert.assertEquals("Tom", response.jsonPath().get("employeeName"));
    }

    @Test
    public void shouldUpdateEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Tom");
        employee.setEmployeeID(1);
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .body(employee)
                .when()
                .put("/employees/1");

        Assert.assertEquals(201, response.getStatusCode());
        Assert.assertEquals("Tom", response.jsonPath().get("employeeName"));
        Assert.assertEquals(1, response.jsonPath().getInt("employeeID"));
    }

    @Test
    public void shouldDeleteEmployee(){
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .when()
                .delete("/employees/1");

        Assert.assertEquals(200, response.getStatusCode());
    }


}
