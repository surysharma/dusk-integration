package com.hedgebenefits.utils;

public enum View {
    company("company/home"),
    login("login"),
    welcome("welcome"),
    datain("company/datain"),
    home("welcome");

    private String value;

    View(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
