package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPage {
    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> allLaptops;//LIST because there are 6 elements
    public void chooseLaptop(WebDriver driver, String laptops){
        for (WebElement laptop:allLaptops){
            if (BrowserUtils.getText(laptop).contains(laptops)){
                BrowserUtils.scrollWithJS(driver,laptop);
                laptop.click();
                break;
            }
        }
    }
}
