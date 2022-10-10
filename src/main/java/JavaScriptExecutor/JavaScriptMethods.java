package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class JavaScriptMethods {
    /*NOTE:JavaScript is really efficient once your normal selenium methods
    are not as expected.
    NOTE2:JavaScript should be your last option to use it since your main language is
    java and using javaScript too much will not make you look professional in real job.
    */
    //GET TITLE METHOD FROM JS
    @Test
    public void GetTitle() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        System.out.println("GetTitle with Driver " + driver.getTitle());
        //we are saying to our driver, works as a js executor.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println("GetTitle with JS " + title);
    }

    @Test
    public void clickJS() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement studentLogin = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", studentLogin);
    }

    @Test//This IS THE MOST COMMON INTERVIEW TECHNICAL AND VERBAL QUESTION.*******
    public void scrollIntoView() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyRight = driver.findElement(By.xpath("//p[.='© Copyrights 2022 Techtorial - All Rights Reserved']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", copyRight);
    }

    /*
          1-Navigate to the techtorial academy
          2-Scrolldown to the browse course
          3-Click Browse course with JS
          4-GetTitle of new opened page "Programs - Techtorial with JS
          5-ScrollDown to the INFORMATION part at the bottom
           */
    @Test
    public void scrollIntoViewTask() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browserCourse = driver.findElement(By.linkText("Browse Course"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", browserCourse);
        js.executeScript("arguments[0].click()", browserCourse);
        String title = js.executeScript("return document.title").toString();
        Assert.assertEquals(title, "Programs - Techtorial");
        WebElement information = driver.findElement(By.xpath("//h2[.='information']"));
        js.executeScript("arguments[0].scrollIntoView(true)", information);
    }

    @Test
    public void JSShortCut() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browserCourse=driver.findElement(By.linkText("Browse Course"));
        BrowserUtils.scrollWithJS(driver,browserCourse);
        BrowserUtils.clickWithJS(driver,browserCourse);
        String title1=BrowserUtils.getTitleWithJS(driver);
        Assert.assertEquals(title1, "Programs - Techtorial");
        WebElement information=driver.findElement(By.xpath("//h2[.='information']"));
        BrowserUtils.scrollWithJS(driver,information);
        Thread.sleep(3000);
        WebElement studentLogin=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        BrowserUtils.scrollWithJS(driver,studentLogin);
        }


        /*
        TASK:
        1-Scroll down to the Get Started button for SDET Course
        2-Click(JS) on get started(SDET)
        3-Validate the title with JS
         */
    @Test
    public void Practice() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browserCourse=driver.findElement(By.linkText("Browse Course"));
        BrowserUtils.scrollWithJS(driver,browserCourse);
        BrowserUtils.clickWithJS(driver,browserCourse);
        WebElement getStartedSDET= driver.findElement(By.xpath("//h4[.='SDET Course']//..//a[.='Get Started']"));//OR //h4[.='SDET Course']/parent::div//a[.='Get Started']
        BrowserUtils.clickWithJS(driver,getStartedSDET);
        String actualTitle=BrowserUtils.getTitleWithJS(driver);
        String expectedTitle="Apply To Techtorial - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);


    }

}
