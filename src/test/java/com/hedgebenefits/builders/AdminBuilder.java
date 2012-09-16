package com.hedgebenefits.builders;

import com.hedgebenefits.domain.Company;
import org.apache.commons.lang.RandomStringUtils;


public class AdminBuilder {

    private String username = RandomStringUtils.randomAlphabetic(10);
    private String password = RandomStringUtils.randomAlphanumeric(10);

    public static AdminBuilder adminBuilder() {
        return new AdminBuilder();
    }

    public Company build() {
        Company company = new Company();
        company.setUsername(this.username);
        company.setPassword(this.password);
        return company;
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
