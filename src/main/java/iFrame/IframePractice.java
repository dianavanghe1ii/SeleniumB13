package iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class IframePractice {
    /*

     */
    @Test
    public void iFrame() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/frames");
        WebElement iFrame=driver.findElement(By.linkText("iFrame"));
        iFrame.click();
        WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox=driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        WebElement selenium=driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        selenium.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
