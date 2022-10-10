package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectPractice {
    @Test
    public void validateFirstOption() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/diana/Downloads/Techtorialhtml.html");
        WebElement boxForCountry= driver.findElement(By.name("country"));
        Select countryBox= new Select(boxForCountry);
        WebElement firstOption = countryBox.getFirstSelectedOption();
        String actualOption=firstOption.getText().trim();
        String expectedOption="UNITED STATES";
        Assert.assertEquals(actualOption,expectedOption);
        countryBox.selectByVisibleText("MOLDOVA");
        Thread.sleep(2000);
        boxForCountry= driver.findElement(By.name("country"));
        countryBox=new Select(boxForCountry);
        firstOption=countryBox.getFirstSelectedOption();
        String actualText= firstOption.getText().trim();
        String expectedText="MOLDOVA";
        Assert.assertEquals(actualOption,expectedOption);
    }
    /*
    Step by step usage of Select Class:
    1-You need to setup your automation.(WebDriverManager, WebDriver, maximize, get)
    2-You need to check the tag name of box(dropdown)--> if it is select tag name then use Select Class
    3-First we need to find the location of the element and store as WebElement.(boxForCountry)
    4-Then We need to instantiate Select object with meaningfulName then provide the location of
    element as parameter.(Select countryBox=new Select(boxForCountry)
    5-Use select methods to be able to do your actions.(GetFirstSelectionOption,GetOptions,SelectValue..)
    6-Validate your expected and actual.
     */

}
