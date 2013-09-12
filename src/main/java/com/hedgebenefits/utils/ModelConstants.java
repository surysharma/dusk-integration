package com.hedgebenefits.utils;

public enum ModelConstants {

    AUTHENTICATION_FAIL("authFailed");
    private String value;

    ModelConstants(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
