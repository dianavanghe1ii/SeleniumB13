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

public class ClickAndHold {
    /*
1-navigate to the website https://demoqa.com/droppable
2-Validate the message inside of the Big box us "Drop Here" -->first validation
3-Get the "Drag me" box and put it into Big box -->DragAndDrop Method
4-Validate the message turned to the "Dropped"
5-Validate the color turned to the "rgba(....)-->you guys know how to get it.
 */

    @Test
    public void dragMeBox() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        WebElement dropBox= driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
        String actualDrop=BrowserUtils.getText(dropBox);
        String expectedDrop="Drop here";
        Assert.assertEquals(actualDrop,expectedDrop);
        WebElement dragBox= driver.findElement(By.xpath("//div[contains(text(),'Drag me')]"));
        String actualDrag= BrowserUtils.getText(dragBox);
        String expectedDrag="Drag me";
        Assert.assertEquals(actualDrag, expectedDrag);
        Actions action= new Actions(driver);
        Thread.sleep(3000);
        action.dragAndDrop(dragBox,dropBox).perform();
        dropBox= driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
        String actualAfterDrop=BrowserUtils.getText(dropBox);
        String expectedAfterDrop="Dropped!";
        Thread.sleep(3000);
        Assert.assertEquals(actualAfterDrop,expectedAfterDrop);
    }
    @Test
    public void dragDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        WebElement dropBox= driver.findElement(By.xpath("//div[@id='draggable']"));
        String actualDrop=BrowserUtils.getText(dropBox);
        String expectedDrop="Drop here";
        Assert.assertEquals(actualDrop,expectedDrop);
        WebElement dragBox= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='Drag me')]"));
        String actualDrag= BrowserUtils.getText(dragBox);
        String expectedDrag="Drag me";
        Assert.assertEquals(actualDrag, expectedDrag);
        Actions action= new Actions(driver);
        Thread.sleep(3000);
        action.dragAndDrop(dragBox,dropBox).perform();
        //dropBox= driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
        String actualAfterDrop=BrowserUtils.getText(dropBox);
        String expectedAfterDrop="Dropped!";
        Assert.assertEquals(actualAfterDrop,expectedAfterDrop);
        String actualColor=dragBox.getCssValue("Background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);

    }
    /*
 1-Navigate to the website "https://demoqa.com/droppable"
 2-Click Accept
 3-Click and hold notAccepted box and release to the Drop box
 4-Validate message is still "Drop here"
 5-Click and hold acceptable box and release to Drop box
 6-Validate the message is "dropped"
 */
    @Test
    public void ClickAndHoldPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        WebElement acceptBox= driver.findElement(By.linkText("Accept"));
        acceptBox.click();
        WebElement notAcceptable= driver.findElement(By.id("notAcceptable"));
        WebElement bigBox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualMessageBefore=BrowserUtils.getText(bigBox);
        String expectedMessageBefore="Drop here";
        Assert.assertEquals(actualMessageBefore, expectedMessageBefore);
        Actions action=new Actions(driver);
        action.clickAndHold(notAcceptable).moveToElement(bigBox).release().perform();
        String actualMessageAfter=BrowserUtils.getText(bigBox);
        String expectedMessageAfter="Drop here";
        Assert.assertEquals(expectedMessageAfter, expectedMessageAfter);

    }
}
