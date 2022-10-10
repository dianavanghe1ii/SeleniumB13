package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindowPractice {
    /*
TASK:
  1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
  2-Click Open New Tab under Button2
  3-Get the title of the newTab and validate"
  4-Get the header of the newTab and validate "AlertsDemo"
  5-Close the newTab
  6-Validate the Header of MainPage(which you navigated first) with "Window Handles Practice"
 */
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button2=driver.findElement(By.id("newTabBtn"));
        BrowserUtils.scrollWithJS(driver,button2);
        button2.click();
        String mainId=driver.getWindowHandle();
//        Set<String> allIds=driver.getWindowHandles();
//        for(String id:allIds){
//            if(!id.equals(mainId)){
//                driver.switchTo().window(id);
//            }
//        }
        BrowserUtils.switchById(driver,mainId);
        String actualTitle=driver.getTitle().trim();
        String expectedTitle="AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
    }
}
