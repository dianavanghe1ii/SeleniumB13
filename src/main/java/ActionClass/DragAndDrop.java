package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class DragAndDrop {
    @Test
    public void dragAndDrop(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement closeCookies= driver.findElement(By.xpath("//button[contains(text(),'Accept Cookies')]"));
        //The reason I create action class is to show that yiu can click methods from actions as
        Actions action= new Actions(driver);
        action.click(closeCookies).perform();
        WebElement circle= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage= BrowserUtils.getText(orangeBox);
        String expectedMessage="... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);

        action.dragAndDrop(circle,orangeBox).perform();
        orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));
        String actualAfterDrop=BrowserUtils.getText(orangeBox);
        String expectedAfterDrop="You did great!";
        Assert.assertEquals(actualAfterDrop,expectedAfterDrop);

    }
}
