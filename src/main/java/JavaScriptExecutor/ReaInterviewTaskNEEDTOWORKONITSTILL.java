package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ReaInterviewTaskNEEDTOWORKONITSTILL {
    @Test
            public void interviewTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.thespruceeats.com/");
        WebElement weatherButton= driver.findElement(By.xpath("//a[.='Warm-Weather Treats']"));
        BrowserUtils.scrollWithJS(driver,weatherButton);
        WebElement videoButton = driver.findElement(By.xpath("//div[@class='jw-media jw-reset']"));
        Thread.sleep(3000);
        videoButton.click();
        driver.quit();
    }
}
