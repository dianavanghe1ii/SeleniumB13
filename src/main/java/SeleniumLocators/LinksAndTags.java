package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAndTags {
    public static void main(String[] args) throws InterruptedException {
        //TagName
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/diana/Downloads/Techtorialhtml.html");
        WebElement javaVersion=driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());

        //LinkText

        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement header=driver.findElement(By.tagName("h1"));
        System.out.println(header.getText());

        //TASK:
        /*
        Can you verify all the links are working on the Techtorial page
        1-go back to main page
        2-you need to click Selenium link and get the title
        3-go back to main page and click Cucumber and sout header of the page
        4-go back to main page and refresh the page
        5-close the page
         */

        driver.navigate().back();
        WebElement selenium= driver.findElement(By.linkText("Selenium"));
        selenium.click();
        driver.navigate().back();
        Thread.sleep(5000);
        javaLink= driver.findElement(By.linkText("Java"));
        javaLink.click();

        System.out.println(driver.getTitle());//you can also use tagName for the title
        Thread.sleep(3000);
        driver.navigate().back();
        WebElement cucumber=driver.findElement(By. linkText("Cucumber"));
        cucumber.click();
        Thread.sleep(3000);
        WebElement headerCucumber=driver.findElement(By.tagName("h1"));
        System.out.println(headerCucumber.getText());
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        //driver.close();

        //PartialLinkText
        WebElement restApi= driver.findElement(By.partialLinkText("Api"));
        restApi.click();


    }
}
