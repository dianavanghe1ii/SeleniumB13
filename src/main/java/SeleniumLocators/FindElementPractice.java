package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
1-navigate to the website
2-click Horizontal Slider with partial or linkText
3-Get the text of header print out
4-Get the text of paragraph print out
5-Click Elemental Selenium
6-VALIDATE(IF CONDITION) the current url
7-close your page

 */
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement horizontal= driver.findElement(By.tagName("Horizontal Slider"));
        horizontal.click();
        Thread.sleep(3000);
        System.out.println(horizontal.getText());
        WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());
        Thread.sleep(3000);
        WebElement paragraph= driver.findElement(By.tagName("h4"));
        System.out.println(paragraph.getText());
        Thread.sleep(3000);
        WebElement elemental= driver.findElement(By.linkText("Elemental Selenium"));
        Thread.sleep(3000);
        elemental.click();
        driver.quit();//closes all the pages that open during Automation

    }
}
