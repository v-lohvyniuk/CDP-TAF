package com.cdp.taf.api;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.springframework.stereotype.Component;
import org.testng.Reporter;

import java.util.Objects;

@Component
public class ApiLogFilter implements Filter {

    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext filterContext) {
        Response response = filterContext.next(requestSpec, responseSpec);
        Reporter.log("================================================================================================");
        Reporter.log("=========================================REQUEST================================================");
        Reporter.log(String.format("METHOD %-10s URI: %-50s", requestSpec.getMethod(), requestSpec.getURI()));
        if (Objects.nonNull(requestSpec.getBody())) {
            Reporter.log(String.format("BODY %s", requestSpec.getBody().toString()));
        }
        Reporter.log("=========================================RESPONSE ==============================================");
        Reporter.log(String.format("STATUS CODE %d", response.getStatusCode()));
        Reporter.log("BODY");
        Reporter.log(response.getBody().prettyPrint());
        Reporter.log("================================================================================================");

        Counter.updateCounter();
        logAPICall(requestSpec, response, Counter.getCounter());
        return response;
    }

    @Step(value = "Call #{counter}: {requestSpec.baseUri}")
    public void logAPICall(FilterableRequestSpecification requestSpec, Response response, Integer counter) {
        logRequest(requestSpec);
        logResponse(response);
    }

    @Attachment(value = "Request")
    public String logRequest(FilterableRequestSpecification requestSpec) {
        return String.format("METHOD: %s \nURI: %s\n", requestSpec.getMethod(), requestSpec.getURI());
    }

    @Attachment(value = "Response")
    public String logResponse(Response response) {
        return String.format("RESPONSE STATUS: %d \nBODY: %s", response.getStatusCode(), response.getBody().prettyPrint());
    }

}
