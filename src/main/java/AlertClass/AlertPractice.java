package AlertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://sweetalert.js.org/");
        WebElement previewButton= driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));//OR
        // h5[contains(text(),'Normal alert')]//..//button[@class='preview']
        previewButton.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement previewButton2= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewButton2.click();
        Thread.sleep(3000);
        WebElement text=driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        Assert.assertEquals(BrowserUtils.getText(text),"Something went wrong!");
        WebElement okButton= driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();

    }
}
