package com.test.blaze.tests;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {
    @DataProvider (name = "validationCustomer")
    public Object[][] provideCustomerinfo(){
        return new Object[][]{
                {"MacBook Pro","Ion","Romania","Craiova","9932 8871","09","2025","Thank you for your purchase!"},
                {"MacBook Pro","Ahmet","Turkey","Craiova","9932 8851","05","2023","Thank you for your purchase!"},
                {"MacBook Pro","Ayse","Turkey","Princess","9932 8871","08","2021","Thank you for your purchase!"},
        };
    }
}
