package com.cdp.taf.api.services;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class TokenService {

    @Autowired
    RequestSpecification request;

    private String REQUEST_TOKEN_BODY = "{\"client_id\":\"gGxAPVvtikjhfJh4ou8ISdD7DcO6wFEJ\"," +
            "\"client_secret\":\"QoLZxwFwob10w-ms7w0KO1INQ9GtqWrg45xsK35CLqqWAapS6Jo_sbPj_Ci8OG-K\"," +
            "\"audience\":\"https://gigabyte.eu.auth0.com/api/v2/\",\"grant_type\":\"client_credentials\"}";

    public ValidatableResponse getToken() {
        return given().spec(request).when().baseUri("https://gigabyte.eu.auth0.com/oauth/token").body(REQUEST_TOKEN_BODY).post().then();
    }
}