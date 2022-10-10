package com.test.sentrifugo.tests;

import org.testng.annotations.DataProvider;

public class LoginTestDataProvider {
    @DataProvider(name = "fullLogin")
    public Object[][] loginData() {
    return new Object[][]{
            {"EM01","sentrifugo"},
            {"EM02","sentrifugo"},
            {"EM03","sentrifugo"},
            {"EM04","sentrifugo"},
            {"EM05","sentrifugo"},
            {"EM06","sentrifugo"},
            {"EM07","sentrifugo"},
            {"AGCY8","sentrifugo"},
            {"US09","sentrifugo"},
        };
    }
}
