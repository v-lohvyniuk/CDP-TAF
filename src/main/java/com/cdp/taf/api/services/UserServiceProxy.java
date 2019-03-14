package com.cdp.taf.api.services;

import com.cdp.taf.api.dto.UserDTO;
import io.restassured.mapper.TypeRef;
import io.restassured.response.ValidatableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceProxy {

    @Autowired
    @Lazy
    UserService userService;

    public ValidatableResponse getUsers() {
        return userService.getUsers();
    }

    public List<UserDTO> getUserModels() {
        return getUsers().extract().as(new TypeRef<List<UserDTO>>() {});
    }

    public ValidatableResponse getUser(int id) {
        return userService.getUser(id);
    }

    public ValidatableResponse createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
}