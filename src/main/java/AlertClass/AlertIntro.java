package AlertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void alertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert= driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        WebElement message=driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));//OR By.Id("result")
        Assert.assertEquals(BrowserUtils.getText(message),"You successfully clicked an alert");

    }
    @Test
    public void dismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm= driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        jsConfirm.click();
        Alert alert=driver.switchTo().alert();
        String actual=alert.getText();
        String expected="I am a JS Confirm";
        alert.dismiss();
        WebElement message= driver.findElement(By.xpath("//p[.='You clicked: Cancel']"));
        Assert.assertEquals(BrowserUtils.getText(message),"You clicked: Cancel");

    }
    @Test
    public void sendKeys() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt()')]"));

        jsPrompt.click();
        Alert alert=driver.switchTo().alert();
        String actual=alert.getText();
        String expected="I am a JS prompt";
        Assert.assertEquals(actual,expected);
        alert.sendKeys("Techtorial");
        alert.accept();
        WebElement message = driver.findElement(By.xpath("//p[contains(text(),'You entered:')]"));////p[contains(@id
        //?????????????????
        Assert.assertEquals(BrowserUtils.getText(message), "You entered: Techtorial");
    }
}
