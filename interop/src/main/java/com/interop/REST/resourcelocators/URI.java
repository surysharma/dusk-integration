package com.interop.REST.resourcelocators;

public enum URI {
    HOST("http://localhost:8899/rest"),
    ROOT("/admin"),
    GET("/id"),
    ADD("/add"),
    UPDATE("/update");

    private String uri;

    URI(String uri) {
        this.uri = uri;
    }

    public String value() {
        return uri;
    }
}
