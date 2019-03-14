package com.cdp.taf.api.services;

import com.cdp.taf.api.dto.TokenDTO;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ClientServiceProxy {

    @Autowired
    @Lazy
    private ClientService clientService;
    @Autowired
    @Lazy
    private TokenService tokenService;

    public ValidatableResponse getClients() {
        TokenDTO tokenDTO = tokenService.getToken().extract().as(TokenDTO.class);
        return clientService.getClients(tokenDTO.getAccessToken());
    }
}