package com.hedgebenefits.domain;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 18/09/2012
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 */
public class Sector {

    private Long id;
    private String sectorName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
}
