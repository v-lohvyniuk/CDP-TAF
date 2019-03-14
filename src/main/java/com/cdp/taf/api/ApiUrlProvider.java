package com.cdp.taf.api;

import com.cdp.taf.api.services.ClientService;
import com.cdp.taf.api.services.UserService;
import com.google.common.collect.ImmutableMap;

public class ApiUrlProvider {

    public static final String DEFAULT_SERVICE_URL = "https://jsonplaceholder.typicode.com/users";

    public static final ImmutableMap<Class, String> SERVICE_URL_MAPPING =
            ImmutableMap.<Class, String>
                    builder()
                    .put(UserService.class, "https://jsonplaceholder.typicode.com/users")
                    .put(ClientService.class, "https://gigabyte.eu.auth0.com/api/v2")
                    .build();

    public static String getFor(Class clazz) {
        return SERVICE_URL_MAPPING.getOrDefault(clazz, DEFAULT_SERVICE_URL);
    }
}
