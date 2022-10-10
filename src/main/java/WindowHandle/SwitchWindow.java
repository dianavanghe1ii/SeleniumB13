package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHereButton= driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();
        WebElement newWindowHeader= driver.findElement(By.tagName("h3"));
        System.out.println(newWindowHeader.getText().trim());
        String mainPageId=driver.getWindowHandle();//F6
        System.out.println(mainPageId);
        Set<String> allPageIds=driver.getWindowHandles();
        System.out.println(allPageIds);//F6
        for (String id:allPageIds){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        newWindowHeader= driver.findElement(By.tagName("h3"));
        System.out.println(newWindowHeader.getText().trim());
        }
    }
