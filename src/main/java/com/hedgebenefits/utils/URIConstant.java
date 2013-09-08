package com.hedgebenefits.utils;

public enum URIConstant {

    ROOT("/"),
    COMPANY_HOME("/admin/companies/");
    private String uri;

    URIConstant(String uri) {
        this.uri = uri;
    }

    public String value() {
        return uri;
    }
}
