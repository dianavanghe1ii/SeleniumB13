package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class Edureka {
    @Test
    public void edurekaTask() throws InterruptedException {
         /*
    1-Navigate to the website "https://www.edureka.co/
    2-Under Browser Categories Choose Browser Testing
    3-Selenium Certification Training Course
    4-Scroll down and get all the topics and hands-on from Java Basic refresher
    5-Print them out on your console
    5-close your page
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.edureka.co/");
        WebElement categories = driver.findElement(By.xpath("//a//span[.='Categories']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(categories).perform();
        Thread.sleep(3000);
        WebElement softwareTesting = driver.findElement(By.xpath("//a[@class='dropdown-toggle ga_top_category' and contains(text(),'Software Testing')]"));
        actions.moveToElement(softwareTesting).perform();
        Thread.sleep(3000);
        WebElement trainingCourse = driver.findElement(By.xpath("//a[.='Selenium Certification Training Course' and @class='ga_top_categories_course']"));
        actions.click(trainingCourse).perform();
        Thread.sleep(3000);
        WebElement javaRefresher = driver.findElement(By.xpath("//h3[.='Java Basics Refresher for Selenium Training Course']"));
        BrowserUtils.scrollWithJS(driver, javaRefresher);
        List<WebElement> allTexts = driver.findElements(By.xpath("//div[@id='21930']//div[@class='ul-li-content-clp']//li"));
        for (WebElement text : allTexts) {
            System.out.println(BrowserUtils.getText(text));
        }
        driver.close();
    }
}
