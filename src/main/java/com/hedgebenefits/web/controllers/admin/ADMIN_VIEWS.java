package com.hedgebenefits.web.controllers.admin;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 07/07/2012
 * Time: 09:49
 * To change this template use File | Settings | File Templates.
 */
public enum ADMIN_VIEWS {
    REGISTER_ADMIN("registration"),
    LIST_ADMINS("list"),;

    private String viewName;

    ADMIN_VIEWS(String viewName) {

        this.viewName = viewName;
    }


    public String getViewName() {
        return this.viewName;
    }

}
