package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocator {

    //Xpath is the boss of locator
    //ABSOLUTE XPATH
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement aBTesting= driver.findElement(By.linkText("A/B Testing"));
        aBTesting.click();
        WebElement paragraph= driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText());
        WebElement seleniumLink= driver.findElement(By.xpath("http://elementalselenium.com/"));
        Thread.sleep(3000);
        seleniumLink.click();
    }

}
