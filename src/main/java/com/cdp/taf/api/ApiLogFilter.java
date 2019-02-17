package com.cdp.taf.api;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.testng.Reporter;

public class ApiLogFilter implements Filter {

    public ThreadLocal<Integer> counter = new ThreadLocal<>();

    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext filterContext) {
        Response response = filterContext.next(requestSpec, responseSpec);
        Reporter.log("================================================================================================");
        Reporter.log("=========================================REQUEST================================================");
        Reporter.log(String.format("WITH METHOD %-10s URI: %-50s", requestSpec.getMethod(), requestSpec.getURI()));
        if (null != requestSpec.getBody()) {
            Reporter.log(String.format("WITH BODY %s", requestSpec.getBody().toString()));
        }
        Reporter.log("=========================================RESPONSE ==============================================");
        Reporter.log(String.format("WITH STATUS CODE %d", response.getStatusCode()));
        Reporter.log("WITH BODY");
        Reporter.log(response.getBody().prettyPrint());
        Reporter.log("================================================================================================");

        updateCounter();
        logAPICall(requestSpec, response, counter.get());
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

    private void updateCounter() {
        if (counter.get() == null) {
            counter.set(1);
        } else {
            counter.set(counter.get() + 1);
        }
    }
}
