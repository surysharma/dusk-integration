package com.interop.REST.resourcelocators;

import com.interop.REST.resources.AdminResource;

import javax.ws.rs.Path;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 04/02/2013
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
@Path("/admin")
public class ResourcePaths {

    @Path("/id")
    public AdminResource produceJson() {
        return new AdminResource();
    }
}
