package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SwitchMultipleWindowsPractice {
    /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-Switch driver to the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-Switch driver to the alertsDemo page and click the any of the "Click Me" button
6-quit all the pages.
7-Proud of yourself
 */
    @Test
    public void MultipleTabsPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement multipleTabs=driver.findElement(By.id("newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,multipleTabs);
        multipleTabs.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String mainId=driver.getWindowHandle();
        BrowserUtils.switchByTitle(driver,"Basic Controls");
        WebElement firstName= driver.findElement(By.id("firstName"));
        BrowserUtils.scrollWithJS(driver,firstName);
        firstName.sendKeys("Diana");
        WebElement lastName= driver.findElement(By.id("lastName"));
        lastName.sendKeys("Vanghelii");
        WebElement gender= driver.findElement(By.id("femalerb"));
//      BrowserUtils.scrollWithJS(driver,gender);
        gender.click();
        WebElement language= driver.findElement(By.xpath("//input[@id='englishchbx']"));
        language.click();
        WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("diana@email.com");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345");
        Thread.sleep(2000);
        WebElement registerButton= driver.findElement(By.xpath("//button[.='Register']"));
        registerButton.click();
        Thread.sleep(2000);
        WebElement successButton= driver.findElement(By.xpath("//label[contains(text(),'Registration is Successful')]"));
        String actualMessage=BrowserUtils.getText(successButton);
        String expectedMessage="Registration is Successful";
        Assert.assertEquals(actualMessage,expectedMessage);
        //Assert.assertTrue(actualMessage.equals(expectedMessage)); OR
        //Assert.assertFalse(!actualMessage.equals(expectedMessage)); not likely to use
        Assert.assertEquals(actualMessage,expectedMessage);
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        Thread.sleep(2000);
        WebElement alertBox= driver.findElement(By.id("alertBox"));
        alertBox.click();
        Thread.sleep(3000);
        driver.quit();





    }
}
