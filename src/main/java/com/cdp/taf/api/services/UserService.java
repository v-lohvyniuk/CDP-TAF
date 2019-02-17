package com.cdp.taf.api.services;

import com.cdp.taf.api.dto.UserDTO;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

@Component
public class UserService extends BaseApiService {

    public UserService(RequestSpecification request) {
        super(request);
    }

    public ValidatableResponse getUsers() {
        return request.when().get().then();
    }

    public ValidatableResponse getUser(int id) {
        return request.pathParam("id", id).when().get("/{id}").then();
    }

    public ValidatableResponse createUser(UserDTO userDTO) {
        return request.body(userDTO).post().then();
    }
}