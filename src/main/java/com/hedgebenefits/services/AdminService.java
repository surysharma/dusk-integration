package com.hedgebenefits.services;

import com.hedgebenefits.domain.Admin;

import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 01/07/2012
 * Time: 21:00
 * To change this template use File | Settings | File Templates.
 */
public interface AdminService {
    void register(Admin admin);
    List<Admin> listAllAdmins();

}
