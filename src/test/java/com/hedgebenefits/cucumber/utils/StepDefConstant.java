package com.hedgebenefits.cucumber.utils;

public enum StepDefConstant {
    BASE_URL("http://localhost:8081%s");
    private final String value;

    StepDefConstant(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
