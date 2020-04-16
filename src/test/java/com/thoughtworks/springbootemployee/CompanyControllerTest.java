package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.controller.CompanyController;
import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import io.restassured.http.ContentType;
import io.restassured.mapper.TypeRef;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyControllerTest {
    @Autowired
    private CompanyController companyController;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(companyController);
    }
    @Test
    public void shouldFindCompanyById() {
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .when()
                .get("/companies/1");

        Assert.assertEquals(200, response.getStatusCode());
        Company company = response.getBody().as(Company.class);
        Assert.assertEquals(1, company.getCompanyID());
    }
    @Test
    public void shouldFindEmployeeByCompanyId() {
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .when()
                .get("/companies/1/employees");

        Assert.assertEquals(200, response.getStatusCode());
        List<Employee> employees = response.getBody().as(new TypeRef<List<Employee>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        Assert.assertEquals("Xiaoming", employees.get(0).getEmployeeName());
    }

    @Test
    public void shouldAddCompany() {
        CompanyRepository companyRepository = new CompanyRepository();
        Company company = new Company(23, "XYZ", 500, companyRepository.getEmployeeByCompanyId(1));
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .body(company)
                .when()
                .post("/companies");

        Assert.assertEquals(201, response.getStatusCode());
        Assert.assertEquals("XYZ", response.jsonPath().get("companyName"));
        Assert.assertEquals(23, response.jsonPath().getInt("companyID"));
    }
    @Test
    public void shouldUpdateCompany() {
        CompanyRepository companyRepository = new CompanyRepository();
        Company company = new Company(1, "XYZ", 500, companyRepository.getEmployeeByCompanyId(1));
        //Company company = new Company();
        //company.setCompanyName("XYZ");
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .body(company)
                .when()
                .put("/companies/1");

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("XYZ", response.jsonPath().get("companyName"));
        Assert.assertEquals(1, response.jsonPath().getInt("companyID"));
    }

    @Test
    public void shouldDeleteCompany(){
        MockMvcResponse response = given().contentType(ContentType.JSON)
                .when()
                .delete("/employee/1");

        Assert.assertEquals(200, response.getStatusCode());
    }











}
