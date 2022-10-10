package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectBasics {
    //to be able to use Select Class, you need to check the tag name of element. It should be "SELECT"
    @Test
    public void practiceSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement dropDown= driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement box=driver.findElement(By.id("dropdown"));
        Select select=new Select(box);
        List<WebElement> allOptions=select.getOptions();//it returns all options from box
        for (WebElement option:allOptions){
            System.out.println(option.getText().trim());
        }
        //GetFirstSelectedOption
        WebElement firstDefaultOption=select.getFirstSelectedOption();
        String actualDefaultOption=firstDefaultOption.getText().trim();
        String expectedDefaultOption="Please select an option";
        Assert.assertEquals(actualDefaultOption,expectedDefaultOption);
        //SelectByValue
        select.selectByValue("2");
        Thread.sleep(3000);

        //SelectByVisibleText
        select.selectByVisibleText("Option 1");
        Thread.sleep(3000);

        //SelectByIndex
        select.selectByIndex(2);

    }
}
