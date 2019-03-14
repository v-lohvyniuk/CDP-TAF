package com.cdp.taf.api.services;

import io.restassured.response.ValidatableResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
@Scope("thread")
public class ClientService extends ApiServiceBase {

    public ValidatableResponse getClients(String token) {
        return given().spec(request).when().header("Authorization", "Bearer " + token).get("/clients").then();
    }
}