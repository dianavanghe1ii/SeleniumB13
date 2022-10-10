package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionMethods {
    //ContextClick(It means rightClick)
    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement context= driver.findElement(By.linkText("Context Menu"));
        context.click();
        WebElement box= driver.findElement(By.id("hot-spot"));
        Actions action= new Actions(driver);
        action.contextClick(box).perform();
    }
    @Test
    public void rightClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClick= driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        Actions action= new Actions(driver);
        action.contextClick(rightClick).perform();
    }
    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickMe= driver.findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));
        Actions action= new Actions(driver);
        action.doubleClick(doubleClickMe).perform();

    }
    @Test
    public void doubleClickAlert(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");
        WebElement doubleClickMe= driver.findElement(By.xpath("//button[contains(text(),'Double-Click me to see Alert message')]"));
        Actions action= new Actions(driver);
        action.doubleClick(doubleClickMe).perform();
    }
}
