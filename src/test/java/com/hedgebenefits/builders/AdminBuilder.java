package com.hedgebenefits.builders;

import com.hedgebenefits.domain.Admin;

import java.util.Random;

public class AdminBuilder {

    private String username = Random.class.;
    private String password;

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
