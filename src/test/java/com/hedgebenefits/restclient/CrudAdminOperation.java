package com.hedgebenefits.restclient;

import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * This class simply performs the CRUD operations on application.
 * Used just as a test client to check CRUD working using REST using JSON and POX
 */
public class CrudAdminOperation {
        String ROOT_URI = "http://localhost:8899/rest/";
        String RESOURCE_PATH = "admin/";
        String ADD = "add";
    private static final String UPDATE = "update/id";

    @Test
    public void postAdminWithJson() {


        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String jsonEmployee = "{\"rights\":\"rights5\",\"username\":\"admin5\"}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(jsonEmployee, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(ROOT_URI.concat(RESOURCE_PATH).concat(ADD), HttpMethod.POST, requestEntity, String.class);
        String id = responseEntity.getBody();
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));
    }


    @Test
    public void putMethodWithJson() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String jsonEmployee = "{\"rights\":\"updatedrights2\",\"username\":\"updatedadmin2\"}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(jsonEmployee, headers);

        Map<String, Long> map = new HashMap<String, Long>();
        map.put("id", 2L);
        ResponseEntity<String> responseEntity = restTemplate.exchange(ROOT_URI.concat(RESOURCE_PATH).concat(UPDATE).concat("/{id}"), HttpMethod.PUT, requestEntity, String.class, map);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));
    }

}
