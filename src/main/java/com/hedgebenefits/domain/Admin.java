package com.hedgebenefits.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Admin {

    private Long id;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Admin)) {
            return false;
        }
        Admin otherAdmin  = (Admin) o;
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(getUserName(), otherAdmin.getUserName());
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getUserName());
        return builder.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("UserName:")
                .append(userName)
                .toString();
    }
}
