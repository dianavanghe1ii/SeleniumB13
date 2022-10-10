package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class MoveByOffSet {
    @Test
    public void moveByOffSet() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        actions.clickAndHold(slider).moveByOffset(0, 0).perform();
        Thread.sleep(3000);
        actions.clickAndHold(slider).moveByOffset(-10, 0).perform();
    }

    @Test
    public void moveOffSetWithPointClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://www.techtorialacademy.com/");
        WebElement contactUs = driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[.='Contact Us']"));
        WebElement copyright = driver.findElement(By.xpath("//p[contains(text(),'© Copyrights 2022 Techtorial - All Rights Reserved')]"));
        Actions actions = new Actions(driver);
        Point point = copyright.getLocation();
        int XCoordinate = point.getX();
        int YCoordinate = point.getY();
        System.out.println(XCoordinate);//this is extra
        System.out.println(YCoordinate);//this is extra
        Thread.sleep(5000);
        actions.moveByOffset(XCoordinate, YCoordinate).click().perform();


    }

    @Test
    public void sliderShortCut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement range = driver.findElement(By.id("range"));
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        String rangeNumber = "3";
        while (!BrowserUtils.getText(range).equals(rangeNumber)) {
            Thread.sleep(1000);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Assert.assertEquals(BrowserUtils.getText(range), rangeNumber);
    }
}
