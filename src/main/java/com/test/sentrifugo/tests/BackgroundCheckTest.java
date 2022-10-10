package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.BackgroundCheckPage;
import com.test.sentrifugo.pages.LoginPage;
import com.test.sentrifugo.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BackgroundCheckTest {
    WebDriver driver;
    @BeforeMethod//We use beforeMethod annotation to execute the code before each test annotation
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
    }
    @Test
    public void validateEmployeeInformation() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM01","sentrifugo");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickBackgroundCheck();
        BackgroundCheckPage backgroundCheckPage=new BackgroundCheckPage(driver);
        backgroundCheckPage.employeeInfo(driver);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);//just for us to see, usually not inserting this
        driver.quit();
    }
}
