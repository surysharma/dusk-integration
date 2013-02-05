package com.interop.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 05/02/2013
 * Time: 19:04
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Admin {
    private String username;
    private String rights;

    public Admin(String username, String rights) {
        this.username = username;
        this.rights = rights;
    }

    public Admin(){}

    public String getUsername() {
        return username;
    }


    public String getRights() {
        return rights;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }
}
