package com.interop.REST.resourcelocators;

import com.interop.REST.resources.AdminResource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 04/02/2013
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
@Path("/admin")
public class ResourcePaths {

    @Path("/id/{id}")
    public AdminResource produceJson(@PathParam("id") Long id, @Context Request request) {
        return new AdminResource(id, request);
    }

    @Path("/add")
    public AdminResource addAdmin() {
        return new AdminResource();
    }

    @Path("/update/id")
    public AdminResource updateAdmin() {
        return new AdminResource();
    }


}
