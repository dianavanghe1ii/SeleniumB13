package TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverHelper;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite Annotations");
        //Used to setup your chrome browser properties
        //used to delete your cookies
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest Annotations");
        //Used to launch your browser
        //WebDriver driver= DriverHelper.getDriver();
    }
    @BeforeClass//1
    public void beforeClass(){//1
        System.out.println("BeforeClass Annotations");
        //Used to navigate to website
    }
    @BeforeMethod//2
    public void beforeMethod(){
        System.out.println("BeforeMethod Annotations");
        //Used for driver in initialization WebDriver drive=DriverHelper.getDriver()
        //driver.get(url)
        //used to log in to the website
    }
    @Test//1
    public void test1(){
        System.out.println("Test 1 Annotation");
    }
    @Test//1
    public void test2(){
        System.out.println("Test 2 Annotation");
    }
    @AfterMethod//2
    public void afterMethod(){
        System.out.println("AfterMethod Annotations");
        //You can teardown under that(driver.quit)
        //you can take screenshot for failed test annotations

    }
    @AfterClass//1
    public void afterClass(){//1
        System.out.println("AfterClass Annotations");
    }
    @AfterTest//1
    public void afterTest(){
        System.out.println("AfterTest Annotations");
    }
    @AfterSuite//1
    public void afterSuite(){
        System.out.println("AfterSuite Annotations");
    }
}
