package com.cdp.taf;

import com.cdp.taf.api.AllureLogListener;
import com.cdp.taf.api.services.ClientServiceProxy;
import com.cdp.taf.api.services.TokenService;
import io.restassured.response.ValidatableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertFalse;

@Listeners(AllureLogListener.class)
@Test(description = "API test for Client service with authorization")
public class ClientApiTest extends APITestBase {

    @Autowired
    @Lazy
    private TokenService tokenService;
    @Autowired
    @Lazy
    private ClientServiceProxy clientService;

    @Test(enabled = false)
    public void testTokenService() {
        ValidatableResponse response = tokenService.getToken();
        response.statusCode(200);
        response.body("token_type", equalTo("Bearer"));
    }

    @Test
    public void getAllClientsPositiveTest() {
        ValidatableResponse response = clientService.getClients();
        response.statusCode(200);
        List list = responseAs(response, List.class);
        assertFalse(list.isEmpty());
    }

    @Test
    public void getAllClientsPositiveTest2() {
        ValidatableResponse response = clientService.getClients();
        response.statusCode(200);
        List list = responseAs(response, List.class);
        assertFalse(list.isEmpty());
    }
}
