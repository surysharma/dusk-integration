package com.hedgebenefits.builders;

import com.hedgebenefits.domain.Admin;
import org.apache.commons.lang.RandomStringUtils;


public class AdminBuilder {

    private String username = RandomStringUtils.random(10);
    private String password = RandomStringUtils.random(10);

    public static AdminBuilder adminBuilder() {
        return new AdminBuilder();
    }

    public Admin build() {
        return new Admin(this.username, this.password);
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
