package com.interop.REST.resources;

import com.interop.dao.AdminRepository;
import com.interop.dao.InteropRepository;
import com.interop.domain.Admin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 06/02/2013
 * Time: 20:07
 * To change this template use File | Settings | File Templates.
 */
public class AdminResource {

    private AdminRepository adminRepository = InteropRepository.getRepository();

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAdminFor(@PathParam("id") Long id) {
        Admin admin = adminRepository.get(id);
        if (admin == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(admin).status(Response.Status.OK).build();
    }
}
