package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitWait {
    @Test
    public void practice(){
        WebDriver driver= DriverHelper.getDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement button=driver.findElement(By.tagName("button"));
        button.click();
        WebElement text=driver.findElement(By.xpath("//h4[.='Hello World!']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        System.out.println(text.getText().trim());
    }
}
