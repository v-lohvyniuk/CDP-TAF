package com.cdp.taf.api.services;

import io.restassured.specification.RequestSpecification;

public class BaseApiService {

    RequestSpecification request;

    public BaseApiService(RequestSpecification request) {
        this.request = request;
    }
}
