package com.hedgebenefits.restclient;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.uri.UriTemplate;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class CrudAdminWithJerseyClient {

    String ROOT_URI = "http://localhost:8080/rest/";
    String RESOURCE_PATH = "admin/";
    String ADD = "add";
    private static final String UPDATE = "update/id";

    @Test
    public void shouldPerformGet() {
        //given
        Client client = Client.create();
        Map<String, String> values = new HashMap<String, String>();
        values.put("id", "3");
        String uri = UriTemplate.createURI("http", "", "localhost", "8080", "/rest/admin/id/{id}", "", "", values, true);
        WebResource resource = client.resource(uri);
        System.out.println(resource.getURI());
        //when
        String s = resource.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        //then
        assertThat(s, notNullValue());

    }
}
