package com.cdp.taf.api.services;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class ClientService extends ApiServiceBase {

    public ClientService(RequestSpecification request) {
        super(request);
    }

    public ValidatableResponse getClients(String token) {
        return given().spec(request).when().header("Authorization", "Bearer " + token).get().then();
    }
}