package com.cdp.taf.api;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.List;

public class AllureLogListener implements ITestListener, IInvokedMethodListener {

    public void onStart(ITestContext iTestContext) {
        RestAssured.filters(new ApiLogFilter());
    }

    @Step("FULL TEST LOG")
    public String getFullTestLog(ITestResult iTestResult) {
        List<String> out = Reporter.getOutput(iTestResult);
        StringBuilder sb = new StringBuilder("Reporter Output: \n");
        for (String s : out) {
            sb.append(s).append("\n");
        }
        return attach(sb.toString());
    }

    @Attachment
    public String attach(String log) {
        return log;
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            getFullTestLog(iTestResult);
        }
    }
}