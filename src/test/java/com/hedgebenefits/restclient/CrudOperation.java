package com.hedgebenefits.restclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hedgebenefits.domain.Employee;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.http.HttpMethod.POST;

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

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String jsonEmployee = gson.toJson(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(newArrayList(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<String>(jsonEmployee, headers);
        restTemplate.exchange("http://localhost:8080/employee/add/", POST, requestEntity, String.class);

    }
}
