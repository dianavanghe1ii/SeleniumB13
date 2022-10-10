package WaitTimes;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class FluentWaitPractice {
    @Test
    public void practice() {
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton= driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        Wait<WebDriver>fluentWait=new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Text on the Page")
                .withTimeout(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement message=fluentWait.until(mydriver->driver.findElement(By.id("message")));
        Assert.assertEquals(BrowserUtils.getText(message),"It's gone!");

    }
}
