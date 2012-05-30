package com.hedgebenefits.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Admin {

    private Long id;
    private String userName;

    public String getUserName() {
        return userName;
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
}
