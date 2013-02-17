package com.interop.REST.resources;

import com.interop.dao.AdminRepository;
import com.interop.dao.InteropRepository;
import com.interop.domain.Admin;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;
import java.util.Map;

import static java.lang.String.valueOf;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 06/02/2013
 * Time: 20:07
 * To change this template use File | Settings | File Templates.
 */
public class AdminResource {

    private Long id;
    Admin admin;

    public AdminResource(Long id, Request request) {
        this.id = id;
        this.admin = adminRepository.get(id);
        String entityTagValue = String.format("%s", admin.hashCode());
        EntityTag responseEntity = new EntityTag(entityTagValue);
        Response.ResponseBuilder responseBuilder = request.evaluatePreconditions(responseEntity);
        if (responseBuilder != null) {
            throw new WebApplicationException(responseBuilder.build());
        }
    }

    public AdminResource(){}

    private static AdminRepository adminRepository = InteropRepository.getRepository();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAdminFor() {
        Admin admin = adminRepository.get(id);
        String entityTagValue = String.format("%s", admin.hashCode());
        EntityTag responseEntity = new EntityTag(entityTagValue);
        if (admin == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(admin).tag(responseEntity).status(Response.Status.OK).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addAdmin(JAXBElement<Admin> admin) {
        Map<Long, Admin> adminData = adminRepository.getAll();
        Long id = Long.valueOf(adminData.size() + 1);
        adminData.put(id, admin.getValue());
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateAdmin(@PathParam("id") Long id, JAXBElement<Admin> admin, @Context Request request) {
        Map<Long, Admin> adminData = adminRepository.getAll();
        Admin existingAdmin = adminData.get(id);
        if (existingAdmin == null) {
            return Response.ok().status(Response.Status.NOT_FOUND).build();
        }

        EntityTag entityTag = new EntityTag(valueOf(admin.hashCode()));
//        Response.ResponseBuilder responseBuilder = request.evaluatePreconditions(entityTag);
//        if (responseBuilder != null){
//            throw new WebApplicationException(responseBuilder.build());
//        }

        adminData.put(id, admin.getValue());
        return Response.ok().status(Response.Status.CREATED).tag(entityTag).build();
    }


}
