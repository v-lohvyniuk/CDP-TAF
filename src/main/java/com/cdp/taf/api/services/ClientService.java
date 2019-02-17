package com.cdp.taf.api.services;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

@Component
public class ClientService extends BaseApiService{


    public ClientService(RequestSpecification request) {
        super(request);
    }

//    public ClientService(RequestSpecification requestSpecification) {
//        request = requestSpecification;
//    }

    public ValidatableResponse getClients(String token) {
        return request.when().header("Authorization", "Bearer " + token).get().then();
    }
}