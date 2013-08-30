package com.hedgebenefits.restclient;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.uri.UriTemplate;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CrudAdminWithJerseyClient {

    String ROOT_URI = "http://localhost:8899/rest/";
    String RESOURCE_PATH = "admin/";
    String ADD = "add";
    private static final String UPDATE = "update/id";
    private static Client client = Client.create();

    private static int STATUS_OK = 200;
    private static int NOT_ALLOWED = 304;
    private static String IF_NONE_MATCH = "If-None-Match";
    private static String HTTP = "http";
    private static String HOSTNAME = "localhost";
    private static String PORT = "8080";
    private static final String IF_MATCH = "If_Match";


    @Test
    public void shouldPerformConditionalGet() {
        //given a URI template
        Map<String, String> pathParams = newHashMap(new String[]{"id", "3"});
        String uri = UriTemplate.createURI(HTTP, "", HOSTNAME, PORT, "/rest/admin/id/{id}", "", "", pathParams, true);

        //and a web resource for it
        WebResource resource = client.resource(uri);
        System.out.println(resource.getURI());

        //when GET request is made for 1st time
        ClientResponse firstResponse = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        //then a fresh resource is returned with status code
        assertThat(firstResponse.getClientResponseStatus().getStatusCode(), is(STATUS_OK));
        System.out.println(firstResponse.getClientResponseStatus().getStatusCode());

        //*********************************************************//

        //when a second GET request is made using the same Entity tag value
        String value = firstResponse.getEntityTag().getValue();
        ClientResponse secondResponse = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .header(IF_NONE_MATCH, "\"" + value + "\"")
                .get(ClientResponse.class);

        //then the Status code returned is
        assertThat(secondResponse.getClientResponseStatus().getStatusCode(), is(NOT_ALLOWED));
        assertThat(secondResponse.getLength(), is(-1));
        assertThat(secondResponse.getEntityTag().getValue(), is(value));
        System.out.println(secondResponse.getClientResponseStatus().getStatusCode());
    }

    @Test
    public void shouldPerformConditionalPut() {
        //Given a GET request is made for a resource
        Map<String, String> pathParams = newHashMap(new String[]{"id", "1"});
        String getUri = UriTemplate.createURI(HTTP, "", HOSTNAME, PORT, "/rest/admin/id/{id}", "", "", pathParams, true);
        //and a web resource for it
        WebResource resource = client.resource(getUri);
        System.out.println(resource.getURI());

        //when GET request is made for 1st time
        ClientResponse firstResponse = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);


        //And a URI template
        Map<String, String> pathParamValues = newHashMap(new String[]{"id", "1"});
        String putUri = UriTemplate
                .createURI(HTTP, "", HOSTNAME, PORT, "/rest/admin/update/id/{id}", "", "", pathParamValues, true);


        //when
        ClientResponse updateResponse = client
                .resource(putUri)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .header(IF_MATCH, "\""+ firstResponse.getEntityTag().getValue() + "\"")
                .entity("{\"rights\":\"updatedrights1\",\"username\":\"updatedadmin1\"}", MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class);
        System.out.println(putUri);

        //then
        assertThat(updateResponse.getClientResponseStatus().getStatusCode(), is(201));
        assertThat(updateResponse.getEntityTag(), notNullValue());
    }

    private <T> HashMap<T, T> newHashMap(T[]... items) {
        if (items == null){
            throw new RuntimeException("Parameter cannot be null");
        }
        HashMap<T, T> map = new HashMap<T, T>();
        for (T[] item : items) {
            map.put(item[0], item[1]);
        }
        return map;
    }

}
