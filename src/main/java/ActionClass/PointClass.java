package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class PointClass {
    @Test
    public void pointClassScrollDown(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://www.techtorialacademy.com/");
        WebElement information=driver.findElement(By.xpath("//h2[.='information']"));
        //BrowserUtils.scrollWithJS(driver,information);
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        Point point = information.getLocation();
//        int xCord=point.getX();
//        int yCord=point.getY();
//        System.out.println(xCord);
//        System.out.println(yCord);
//        js.executeScript("window.scrollTo("+xCord+","+yCord+")");
        BrowserUtils.scrollWithPoint(driver,information);
    }
}
