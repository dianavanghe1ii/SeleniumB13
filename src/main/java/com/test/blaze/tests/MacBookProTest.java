package com.test.blaze.tests;

import MentoringWithAhmet.com.test.Bank.tests.TestBase;
import com.test.blaze.pages.*;
import com.test.blaze.pages.MacBookProPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MacBookProTest extends TestBase {
//    WebDriver driver;
//    @BeforeMethod
//    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//    }
    @Test
    public void validateProduct() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.clickLaptops();
        Thread.sleep(3000);
        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.chooseLaptop(driver,"MacBook Pro");
        MacBookProPage mackBookProPage=new MacBookProPage(driver);
        Assert.assertEquals(mackBookProPage.validateProductName(),"MacBook Pro");
        Assert.assertEquals(mackBookProPage.validatePrice(),"$1100 *includes tax");
        Assert.assertEquals(mackBookProPage.validateDescription(),"Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        mackBookProPage.addToCartClick();
        mackBookProPage.validateMessage(driver);
        mackBookProPage.clickCartButton();
        CartPage cartPage=new CartPage(driver);
        cartPage.clickPlaceOrderButton();
    }
//    @AfterMethod
//    public void tearDown(){
//        //driver.quit
//    }
}
