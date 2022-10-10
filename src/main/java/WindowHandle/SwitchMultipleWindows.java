package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void MultipleTabsPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");
        String mainId= driver.getWindowHandle();;
        //BrowserUtils.switchById(driver,mainId); this will not work for more than 2 webpages
//        Set<String> allPagesIds=driver.getWindowHandles();
//        for (String id:allPagesIds){
//            driver.switchTo().window(id);
//            if (driver.getTitle().contains("About Us")){
//                break;
//            }
//        }
        BrowserUtils.switchByTitle(driver,"Home Page");
        System.out.println(driver.getTitle());
    }
}
