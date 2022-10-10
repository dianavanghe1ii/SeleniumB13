package SeleniumLocators;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class CSSLocator {
    @Test
    public void cssLocators(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.etsy.com/");
        WebElement searchBar= driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBar.sendKeys("Watch", Keys.ENTER);
        WebElement allTools= driver.findElement(By.cssSelector(".group_checkbox"));
        System.out.println(BrowserUtils.getText(allTools));
    }
    @Test
    public void cssLocatorPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/diana/Downloads/Techtorialhtml.html");
        WebElement allTools= driver.findElement(By.cssSelector(".group_checkbox"));
        System.out.println(BrowserUtils.getText(allTools));

    }
}
