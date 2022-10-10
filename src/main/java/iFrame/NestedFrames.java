package iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrames {
    @Test
    public void iFrame() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/frames");
        WebElement nestedFrame= driver.findElement(By.partialLinkText("Nested"));
        nestedFrame.click();
        driver.switchTo().frame("frame-top");//OR 0 instead of "frame-top"
        driver.switchTo().frame("frame-left");
        WebElement leftElement= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        //Assert.assertTrue(BrowserUtils.getText(leftElement).equals("LEFT"));
        softAssert.assertEquals(BrowserUtils.getText(leftElement),"LEFT");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleElement = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));//OR By.Id("content")
        Assert.assertTrue(BrowserUtils.getText(middleElement).equals("MIDDLE"));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightElement = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        //Assert.assertTrue(BrowserUtils.getText(rightElement).equals("RIGHT"));
        softAssert.assertEquals(BrowserUtils.getText(rightElement),"RIGHT");
//        driver.switchTo().parentFrame();//top frame
//        driver.switchTo().parentFrame();//main html
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomElement = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
       // Assert.assertTrue(BrowserUtils.getText(bottomElement).equals("BOTTOM"));
        softAssert.assertEquals(BrowserUtils.getText(bottomElement),"BOTTOM");
        softAssert.assertAll();

    }

}
