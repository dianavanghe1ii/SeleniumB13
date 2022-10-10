package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.*;

public class HoverOver {
    @Test
    public void hoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> usernames = driver.findElements(By.tagName("h5"));
        List<WebElement> allImages = driver.findElements(By.xpath("//div[class='figure']//img"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name:user1", "name:user2", "name:user3");
        //We should use asList method to make our code more professional and also less code.
        //The example asList does exactly the same as the above 3 lines of code
//        actualNames.add("name:user1");
//        actualNames.add("name:user2");
//        actualNames.add("name:user3");


        Actions actions = new Actions(driver);
        for (int i = 0; i < usernames.size(); i++) {
            Thread.sleep(3000);
            actions.moveToElement(allImages.get(i)).perform();
            System.out.println(BrowserUtils.getText(usernames.get(i)));
        }
        Assert.assertEquals(actualNames, expectedNames);
    }

    @Test
    public void HoverOverPractice() throws InterruptedException {
        /*
1-Navigate to the website "https://demos.telerik.com/kendo-ui/fx/expand"
2-If you see Accept Cookies, then click otherwise you are good
3-Get all the names of the products and prices separately and store them in separate lists
  *1 list for names
  *1 list for prices
4-Sort them out of loops
5-Print them out

 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        Actions actions = new Actions(driver);
        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        actions.click(acceptCookies);
        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        List<String> listOfNames = new ArrayList<>();
        List<Double> listOfPrices = new ArrayList<>();
        Map<String, Double> allNamesAndPrices = new HashMap<>();
        actions.scrollByAmount(100, 100);
        for (int i = 0; i < allImages.size(); i++) {
            actions.moveToElement(allImages.get(i)).perform();
            listOfNames.add(BrowserUtils.getText(allNames.get(i)));
            listOfPrices.add(Double.parseDouble(BrowserUtils.getText(allPrices.get(i)).substring(1)));//intentionally fail
            allNamesAndPrices.put(listOfNames.get(i), listOfPrices.get(i));
        }
        Collections.sort(listOfNames);
        Collections.sort(listOfPrices);
        System.out.println(listOfPrices);
        System.out.println(listOfNames);
        System.out.println(allNamesAndPrices);

    }

}
