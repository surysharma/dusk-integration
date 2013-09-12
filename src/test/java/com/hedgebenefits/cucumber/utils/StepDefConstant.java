package com.hedgebenefits.cucumber.utils;

public enum StepDefConstant {
    BASE_URL("http://localhost:8081");
    private final String value;

    StepDefConstant(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public String buildCompleteUrlWith(String uri) {
        return String.format(BASE_URL.value().concat("%s"), uri);
    }
}
