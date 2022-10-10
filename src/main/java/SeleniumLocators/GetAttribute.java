package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.WatchEvent;
import java.util.List;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        List<WebElement> boxes=driver.findElements(By.xpath("//div[@role='checkbox']"));
        for (WebElement box:boxes){
            if (box.getAttribute("aria-checked").equals("false")){
                box.click();
            }
        }
    }
}
