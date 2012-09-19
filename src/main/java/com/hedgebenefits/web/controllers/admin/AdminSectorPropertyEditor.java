package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.AdminSector;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 18/09/2012
 * Time: 22:44
 * To change this template use File | Settings | File Templates.
 */

public class AdminSectorPropertyEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        Object value = getValue();
        if (value == null){
            return "";
        }
        return super.getAsText();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void setAsText(String text){
        AdminSector adminSector = new AdminSector();
        adminSector.setAdminSectorId(Long.getLong(text));
        setValue(adminSector);
    }
}
