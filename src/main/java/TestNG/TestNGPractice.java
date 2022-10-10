package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestNGPractice {
    @Test
    public void Url() {

    }
    @Test
    public void validateTitleAndUrl() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName= driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        Thread.sleep(3000);
        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        Thread.sleep(3000);
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement closeButton= driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(3000);
        String actualTitle=driver.getTitle().trim();
        String expectedTitle="Dashboard";
        Assert.assertEquals(actualTitle,expectedTitle);
        //Validate URL
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://demo.opencart.com/admin/";
        Assert.assertEquals(actualUrl.contains(expectedUrl),true);

    }
    /*
        TASK1:
        Click Catalog button and Validate if the Products option is on the list
         */
    @Test
    public void validateProducts() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName= driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        Thread.sleep(3000);
        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        Thread.sleep(3000);
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement closeButton= driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalog= driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        WebElement products= driver.findElement(By.xpath("//a[.='Products']"));//OR Contains like previous
        Assert.assertTrue(products.isDisplayed());

    }
    /*
TASK3
1-Create for loop(starts from i=1) not click first box because it selects everything
2-Find all the boxes elements and store them in the List
3-Validate all boxes are displayed(1 one 1 in for loop)
4-Click the box and validate the box is selected after that.
*/
//        WebElement box= driver.findElement(By.xpath("//input[@type='checkbox']"));
//        int i=0;
//        for (int i=1; i<box.getSize();i++ ){
//            box.get(i).sendKeys(Keys.ARROW_DOWN);
//
    @Test
    public void validateBoxes() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("demo");
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);
        WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
        products.click();
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < allBoxes.size(); i++) {
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
//            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN); if screen is small
            allBoxes.get(i).click();
//            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(300);
            Assert.assertTrue(allBoxes.get(i).isSelected());
        }

    }
        @Test
        public void validateProductsAscendingOrder() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/admin/");
            WebElement userName = driver.findElement(By.id("input-username"));
            userName.sendKeys("demo");
            Thread.sleep(3000);
            WebElement password = driver.findElement(By.id("input-password"));
            password.sendKeys("demo");
            Thread.sleep(3000);
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
            Thread.sleep(3000);
            WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
            closeButton.click();
            WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
            catalog.click();
            WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
            Thread.sleep(3000);
            products.click();
            List<WebElement> allBrands=driver.findElements(By.xpath("//tr//td[3]"));//INDEXING-suggested for tables
            List<String> actualBrands=new ArrayList<>();
            List<String> expectedBrands=new ArrayList<>();
            for (int i=1;i<allBrands.size();i++){
                actualBrands.add(allBrands.get(i).getText().trim());
                expectedBrands.add(allBrands.get(i).getText().trim());
                Collections.sort(expectedBrands);
                Assert.assertEquals(actualBrands,expectedBrands);
            }
            System.out.println(actualBrands);
            System.out.println(expectedBrands);

        }
    /*
HOMEWORK:
Validation for the functionality of ProductName Button

1-Click productName button
2-Then validate if all the brands are descending order.
TIPS:Think about Collections.sort and Collections.reverse.
TIPS2:Similar logic with ascending order but you need couple more steps to complete this task
1-Click ProductName
2-Reverse the list
*/
        @Test
    public void productNameReversed() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/admin/");
            WebElement userName = driver.findElement(By.id("input-username"));
            userName.sendKeys("demo");
            Thread.sleep(2000);
            WebElement password = driver.findElement(By.id("input-password"));
            password.sendKeys("demo");
            Thread.sleep(2000);
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
            Thread.sleep(2000);
            WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
            closeButton.click();
            WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
            catalog.click();
            WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
            Thread.sleep(2000);
            products.click();
            WebElement productNameButton=driver.findElement(By.xpath("//a[.='Product Name']"));
            Thread.sleep(1000);
            productNameButton.click();
            Thread.sleep(1000);
            List<WebElement> allBrands=driver.findElements(By.xpath("//td[@class='text-start']"));
            List<String> actualBrands=new ArrayList<>();
            List<String> expectedBrands=new ArrayList<>();
            for (int i=1;i<allBrands.size();i++){
                actualBrands.add(allBrands.get(i).getText().toUpperCase().trim());
                expectedBrands.add(allBrands.get(i).getText().toUpperCase().trim());
                Collections.sort(expectedBrands);
                Thread.sleep(1000);
                Collections.reverse(expectedBrands);
                Assert.assertEquals(actualBrands,expectedBrands);
            }
            System.out.println(actualBrands);//this is just for me
            System.out.println(expectedBrands);//this is just for me

        }

    }

