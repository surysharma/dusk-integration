package com.hedgebenefits.builders;

import com.hedgebenefits.domain.Admin;
import org.apache.commons.lang.RandomStringUtils;


public class AdminBuilder {

    private String username = RandomStringUtils.randomAlphabetic(10);
    private String password = RandomStringUtils.randomAlphanumeric(10);

    public static AdminBuilder adminBuilder() {
        return new AdminBuilder();
    }

    public Admin build() {
        Admin admin = new Admin();
        admin.setUsername(this.username);
        admin.setPassword(this.password);
        return admin;
    }

    public AdminBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public AdminBuilder withPassword(String password) {
        this.password = password;
        return this;
    }
}
