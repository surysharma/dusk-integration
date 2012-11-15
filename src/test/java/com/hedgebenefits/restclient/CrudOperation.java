package com.hedgebenefits.restclient;

import com.hedgebenefits.domain.Employee;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class simply performs the CRUD operations on application. Used just as a test client to check CRUD working using REST
 */
public class CrudOperation {

    @Test
    public void checkGetMethod() {
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id", "2231");
        ResponseEntity<String> result = restTemplate
                .getForEntity("http://localhost:8080/employee/{id}", String.class, map);
        System.out.println(result.getBody());
    }


    @Test
    public void postMethod() {
        RestTemplate restTemplate = new RestTemplate();
        Employee employee = new Employee.EmployeeBuilder().id(213L).name("poster").niNumber("WE34KL3").build();
        HttpHeaders httpHeaders = new HttpHeaders();
        List<MediaType> mediaTypeList = new ArrayList<MediaType>();
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(mediaTypeList);
        HttpEntity<Employee> httpEntity = new HttpEntity<Employee>(employee,httpHeaders);

        ResponseEntity<Employee> result = restTemplate.postForEntity("http://localhost:8080/employee/add/", httpEntity, Employee.class);

    }
}
