package com.test.etsy.tests;

import com.test.etsy.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainTest extends TestBase {
    @Parameters({"key","word1","word2","word3"})
    @Test
    public void validateSearch(String key, String word1, String word2, String word3){
        MainPage mainPage=new MainPage(driver);
        mainPage.search(key);
        mainPage.validateHeaders(word1, word2, word3);
    }
}
