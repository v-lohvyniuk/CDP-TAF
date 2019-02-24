package com.cdp.taf.api.services;

import com.cdp.taf.api.dto.UserDTO;
import io.restassured.response.ValidatableResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
@Scope("thread")
public class UserService extends ApiServiceBase {

    public ValidatableResponse getUsers() {
        return given().spec(request).when().get().then();
    }

    public ValidatableResponse getUser(int id) {
        return given().spec(request).pathParam("id", id).when().get("/{id}").then();
    }

    public ValidatableResponse createUser(UserDTO userDTO) {
        return given().spec(request).body(userDTO).post().then();
    }
}