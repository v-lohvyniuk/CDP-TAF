package com.cdp.taf.api.services;

import com.cdp.taf.api.ApiUrlProvider;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class ApiServiceBase {

    @Autowired
    RequestSpecification request;

    @PostConstruct
    public void setUp() {
        request.baseUri(ApiUrlProvider.getFor(this.getClass()));
    }

}