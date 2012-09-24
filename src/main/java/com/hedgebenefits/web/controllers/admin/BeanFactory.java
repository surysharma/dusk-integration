package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.daos.impl.AdminDaoImpl;
import com.hedgebenefits.services.AdminService;
import com.hedgebenefits.services.impl.AdminServiceImpl;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 24/09/2012
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public class BeanFactory {
    public static AdminService getAdminService() {
        return new AdminServiceImpl(new AdminDaoImpl());  //To change body of created methods use File | Settings | File Templates.
    }
}
