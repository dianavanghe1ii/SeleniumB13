package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class PlaceOrderPage {
    public PlaceOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;
    @FindBy(xpath = "//input[@id='country']")
    WebElement country;
    @FindBy(xpath = "//input[@id='city']")
    WebElement city;
    @FindBy(xpath = "//input[@id='card']")
    WebElement creditCard;
    @FindBy(xpath = "//input[@id='month']")
    WebElement month;
    @FindBy(xpath = "//input[@id='year']")
    WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement thankYouMessage;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;
    public void fillAllInformation(String name,String country,String city,
                                   String creditCard,String month,String year) throws InterruptedException {
        Thread.sleep(2000);
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(creditCard);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        purchaseButton.click();
    }
    public void clickOkButton(){
        okButton.click();
    }
                                //if you validate more than 1 element, then do assertion under page class method.
    public String finalMessage(){//if you validate only 1 thing, then do assertion under test class
        return BrowserUtils.getText(thankYouMessage);
    }

}
