package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        //We are setting up our automation
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //Windows user needs to put chromedriver.exe
        //Apple user needs t put chromedriver
        WebDriver driver = new ChromeDriver();

        //maximize will maximize your window/screen
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");//get method--> navigates to the website that you want
        System.out.println(driver.getTitle());//getTitle method gives us the title of the page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page - Techtorial";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        //2 method-->driver.getCurrentUrl-gives you the url of the page

        //Ctrl+Alt+L and Command+option+L --> organizes the code
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://www.techtorialacademy.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        driver.close();//it closes your driver
    }
}
