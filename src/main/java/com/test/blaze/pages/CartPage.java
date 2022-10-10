package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;
    @FindBy(xpath = "//input[@id='name']")
    WebElement name;
    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }
}
