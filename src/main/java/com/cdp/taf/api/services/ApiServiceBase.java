package com.cdp.taf.api.services;

import io.restassured.specification.RequestSpecification;

public class ApiServiceBase {

    RequestSpecification request;

    public ApiServiceBase(RequestSpecification request) {
        this.request = request;
    }
}
