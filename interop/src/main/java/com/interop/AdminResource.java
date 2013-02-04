package com.interop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 04/02/2013
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
@Path("/test")
public class AdminResource {

    @GET
    @Produces("text/plain")
    public String produceText(){
        return "test from REST!";
    }
}
