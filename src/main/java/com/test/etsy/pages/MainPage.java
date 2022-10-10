package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.Locale;

public class MainPage {
    public MainPage(WebDriver driver){
    PageFactory.initElements(driver,this);
}
    @FindBy(css ="#global-enhancements-search-query")//OR by Xpath,...
    WebElement searchBox;
    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeaders;


    public void search(String key){
        searchBox.sendKeys(key, Keys.ENTER);
    }
    public boolean validateHeaders(String word1,String word2, String word3) {
        for (WebElement header:allHeaders){
            String head= BrowserUtils.getText(header).toLowerCase(Locale.ROOT);
            if (!(head.contains(word1)||head.contains(word2)||head.contains(word3))){
                return  false;
            }
        }
        return true;
    }
}
