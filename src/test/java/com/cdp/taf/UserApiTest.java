package com.cdp.taf;

import com.cdp.taf.api.AllureLogListener;
import com.cdp.taf.api.dto.UserDTO;
import com.cdp.taf.api.services.UserServiceProxy;
import io.restassured.mapper.TypeRef;
import io.restassured.response.ValidatableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

@Listeners(AllureLogListener.class)
@Test(description = "API test for User service")
public class UserApiTest extends APITestBase {

    @Autowired
    @Lazy
    private UserServiceProxy userService;

    @Test(description = "Get all users and verify list size")
    public void verifyUsersAmountPositiveTest() {
        ValidatableResponse response = userService.getUsers();
        response.statusCode(200);
        assertEquals((responseAs(response, List.class)).size(), 10);
    }

    @Test(description = "Verify first user has correct values")
    public void verifyFirstUserPositiveTest() {
        ValidatableResponse response = userService.getUser(1);
        response.statusCode(200);
        response.body("name", equalTo("Leanne Graham"));
        response.body("email", equalTo("Sincere@april.biz"));
    }

    @Test(description = "Create new user")
    public void createUserPositiveTest() {
        int usersCount = userService.getUsers().extract().as(new TypeRef<List<UserDTO>>() {
        }).size();
        ValidatableResponse response = userService.createUser(UserDTO.getDefaultUserDTO(usersCount + 1));
        response.statusCode(201);
        assertEquals(response.extract().as(UserDTO.class), UserDTO.getDefaultUserDTO(usersCount + 1));
        assertEquals(userService.getUsers().extract().as(List.class).size(), usersCount + 1);
    }

    @Test(description = "Test converting to model")
    public void convertToListTest() {
        List<UserDTO> list = userService.getUserModels();
        assertEquals(list.size(), 10);
    }
}