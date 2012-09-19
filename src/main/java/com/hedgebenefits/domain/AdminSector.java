package com.hedgebenefits.domain;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 18/09/2012
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 */
public class AdminSector {

    private Long adminSectorId;

    private String adminSectorName;

    public String getAdminSectorName() {
        return adminSectorName;
    }

    public void setAdminSectorName(String adminSectorName) {
        this.adminSectorName = adminSectorName;
    }

    public Long getAdminSectorId() {
        return adminSectorId;
    }

    public void setAdminSectorId(Long adminSectorId) {
        this.adminSectorId = adminSectorId;
    }
}
