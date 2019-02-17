package com.cdp.taf.api.services;

import com.cdp.taf.api.dto.UserDTO;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TokenService {

    private String REQUEST_TOKEN_BODY = "{\"client_id\":\"gGxAPVvtikjhfJh4ou8ISdD7DcO6wFEJ\"," +
            "\"client_secret\":\"QoLZxwFwob10w-ms7w0KO1INQ9GtqWrg45xsK35CLqqWAapS6Jo_sbPj_Ci8OG-K\"," +
            "\"audience\":\"https://gigabyte.eu.auth0.com/api/v2/\",\"grant_type\":\"client_credentials\"}";

    @Autowired
    @Lazy
    RequestSpecification request;

    public ValidatableResponse getToken() {
        return request.when().baseUri("https://gigabyte.eu.auth0.com/oauth/token").body(REQUEST_TOKEN_BODY).post().then();
    }

}