package com.interop.REST.resources;

import com.interop.dao.AdminRepository;
import com.interop.dao.InteropRepository;
import com.interop.domain.Admin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    public Admin getAdminFor(@PathParam("id") Long id) {
        return adminRepository.get(id);
    }
}
