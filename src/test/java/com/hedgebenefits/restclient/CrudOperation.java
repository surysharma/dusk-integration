package com.hedgebenefits.restclient;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hedgebenefits.domain.Employee;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * This class simply performs the CRUD operations on application.
 * Used just as a test client to check CRUD working using REST using JSON and POX
 */
public class CrudOperation {

    @Test
    public void checkGetMethodWithJson() {
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id", "2231");
        ResponseEntity<String> result = restTemplate
                .getForEntity("http://localhost:8080/employee/{id}", String.class, map);
        System.out.println(result.getBody());
    }


    @Test
    public void postMethodWithJson() {
        RestTemplate restTemplate = new RestTemplate();
        Employee employee = new Employee.EmployeeBuilder().id(213L).name("poster").niNumber("WE34KL3").build();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String jsonEmployee = gson.toJson(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(jsonEmployee, headers);
        restTemplate.exchange("http://localhost:8080/employee/add/", HttpMethod.POST, requestEntity, String.class);
    }

    @Test
    public void postAdminWithJson() {

        String ROOT_URI = "http://localhost:8080/rest/";
        String RESOURCE_PATH = "admin/";
        String OPERATION = "add";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String jsonEmployee = "{\"rights\":\"rights5\",\"username\":\"admin5\"}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(jsonEmployee, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(ROOT_URI.concat(RESOURCE_PATH).concat(OPERATION), HttpMethod.POST, requestEntity, String.class);
        String id = responseEntity.getBody();
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));

        requestEntity = new HttpEntity<String>(id);
//        ResponseEntity<String> exchange = restTemplate.exchange(ROOT_URI.concat(RESOURCE_PATH).concat("id/{id}"), HttpMethod.GET, requestEntity, String.class);
//        assertThat(exchange, notNullValue());
//            restTemplate.exchange(ROOT_URI.concat(RESOURCE_PATH).concat("id/{id}"), HttpMethod.GET, requestEntity, String.class);
    }


    @Test
    public void putMethodWithJson() {
        RestTemplate restTemplate = new RestTemplate();
        Employee employee = new Employee.EmployeeBuilder().id(213L).name("poster").niNumber("WE34KL3").build();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String jsonEmployee = gson.toJson(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> map = Maps.<String, String>newHashMap();
        map.put("id", "42");
        headers.setAll(map);
        HttpEntity<String> requestEntity = new HttpEntity<String>(jsonEmployee, headers);

        restTemplate.exchange("http://localhost:8080/employee/update/{id}", HttpMethod.PUT, requestEntity, String.class, "42");
    }

    @Test
    public void deleteMethodWithJson() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        restTemplate.exchange("http://localhost:8080/employee/update/{id}", HttpMethod.DELETE, requestEntity, String.class, "42");
    }

    //-----------------NOW WITH POX------------------------------------------

    @Test
    public void getMethodWithPOX() {
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id", "2231");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(newArrayList(MediaType.APPLICATION_XML));
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);


        ResponseEntity<String> result = restTemplate
                .exchange("http://localhost:8080/employee/{id}", HttpMethod.GET, requestEntity, String.class, "344");
        System.out.println(result.getBody());
    }

    @Test
    public void postMethodWithPOX() {
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id", "2231");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        String xmlEmp = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><employee><id>782</id><name>poster</name><niNumber>WE34KL3</niNumber></employee>";
        HttpEntity<String> requestEntity = new HttpEntity<String>(xmlEmp, headers);


        ResponseEntity<String> result = restTemplate
                .exchange("http://localhost:8080/employee/add/", HttpMethod.POST, requestEntity, String.class);
        System.out.println(result.getBody());
    }
/*
    @Test
    public void prepareXml() throws JAXBException, IOException {
        Employee employee = new Employee.EmployeeBuilder().id(213L).name("poster").niNumber("WE34KL3").build();

        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        OutputStream os = null;
        try{
         os = new FileOutputStream(new File("temp.xml"));

         marshaller.marshal(employee, os);
        }
        finally {
            if (os != null)  os.close();
        }
    }*/
}
