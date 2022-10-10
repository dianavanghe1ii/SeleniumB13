package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;

public class SelectTourPractice {
    @Test
    public void validateMessage() throws InterruptedException {
        /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulca"
5-Choose the date August 15th
6-Choose the depart from is Paris
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
9-Print out all the options from Airline
10-Choose the Unified option from airline list
11-Click Continue
12-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Avaialble.
 NOTE2:You can use any select method value,visibleText

 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement flightType= driver.findElement(By.xpath("//input[@value='oneway']"));
        flightType.click();
        WebElement passengerNumber= driver.findElement(By.name("passCount"));
        Select passengerBox= new Select( passengerNumber);
        passengerBox.selectByValue("4");
        Thread.sleep(3000);
        WebElement departingCity= driver.findElement(By.name("fromPort"));
        Select departingCityBox= new Select( departingCity);
        String departActualOption= departingCityBox.getFirstSelectedOption().getText().trim();
        String expectedOption="Acapulco";
        Assert.assertEquals(departActualOption,expectedOption);
        departingCityBox.selectByValue("Paris");
        Thread.sleep(3000);
        WebElement departingMonth= driver.findElement(By.name("fromMonth"));
        Select departingMonthBox= new Select( departingMonth);
        departingMonthBox.selectByVisibleText("August");
        Thread.sleep(3000);
        WebElement departingDay= driver.findElement(By.name("fromDay"));
        Select departingDayBox= new Select( departingDay);
        departingDayBox.selectByValue("15");
        Thread.sleep(3000);
        WebElement arrivalCity= driver.findElement(By.name("toPort"));
        Select arrivalCityBox= new Select( arrivalCity);
        arrivalCityBox.selectByValue("San Francisco");
        Thread.sleep(3000);
        WebElement arrivalMonth= driver.findElement(By.name("toMonth"));
        Select arrivalMonthBox= new Select( arrivalMonth);
        arrivalMonthBox.selectByValue("12");
        Thread.sleep(3000);
        WebElement arrivalDay= driver.findElement(By.name("toDay"));
        Select arrivalDayBox= new Select( arrivalDay);
        arrivalDayBox.selectByValue("15");
        Thread.sleep(3000);
        WebElement firstClass= driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        WebElement airlines= driver.findElement(By.xpath("//select[@name='airline']"));
        Select options=new Select(airlines);
        List<WebElement> allOptions=options.getOptions();
        for (WebElement option:allOptions){
            System.out.println(option.getText().trim());
        }
        options.selectByVisibleText("Unified Airlines");
        WebElement continueButton= driver.findElement(By.name("findFlights"));
        continueButton.click();
        WebElement message= driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage=message.getText().trim();
        String expectedMessage="After flight finder - No Seats Avaialble";
        Assert.assertEquals(actualMessage,expectedMessage);




    }
    @Test
    public void SecondWayOfSelectPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement flightType= driver.findElement(By.xpath("//input[@value='oneway']"));
        flightType.click();
        WebElement passengerNumber= driver.findElement(By.name("passCount"));
        BrowserUtils.selectBy(passengerNumber,"4","value");
        WebElement departingCity= driver.findElement(By.name("fromPort"));
        BrowserUtils.selectBy(departingCity,"Paris","value");
        WebElement departingMonth = driver.findElement(By.name("fromMonth"));
        BrowserUtils.selectBy(departingMonth,"August", "value");




    }
}
