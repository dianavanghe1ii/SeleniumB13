package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacBookProPage {

    public MacBookProPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement brandName;
    @FindBy(tagName = "h3")
    WebElement price;
    @FindBy(id = "myTabContent")
    WebElement description;
    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCart;
    @FindBy(id="cartur")
    WebElement cartButton;

    public String validateProductName() {
        return BrowserUtils.getText(brandName);
    }

    public String validatePrice() {
        return BrowserUtils.getText(price);
    }

    public String validateDescription() {
        return BrowserUtils.getText(description);
    }
    //THIS IS NOT PROFESSIONAL AND WE USE IF WE NEED Different methods

    public void addToCartClick() {
        addToCart.click();
    }
    public void validateMessage(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"Product added");
        alert.accept();
    }
    public void clickCartButton(){
        cartButton.click();
    }
}
