package com.hedgebenefits.utils;

public enum View {
    company("company/home"), login("");
    private String value;

    View(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
