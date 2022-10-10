package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {
    /*
TASK 1:
1-navigate to the internet-herokuapp
2-print out all the links
 */
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks = driver.findElements(By.tagName("li"));//or By.xpath("//li")
        int counter=0;
        for (WebElement link:allLinks){
            if (link.getText().trim().length()<12)
            System.out.println(link.getText().trim());
            counter++;
        }
        System.out.println(counter);


        /*
        TASK:

         */

    }
}
