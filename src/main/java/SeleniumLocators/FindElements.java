package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    //findElements(); method
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/diana/Downloads/Techtorialhtml.html");
        List<WebElement>  allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement box:allBoxes){
            if (box.isDisplayed()&&!box.isSelected()) {
                box.click();
            }
        }

    }
}
