package MentoringWithAhmet.com.test.Bank.tests;

import MentoringWithAhmet.com.test.Bank.pages.LoginPage;
import MentoringWithAhmet.com.test.Bank.pages.ManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ManagerTest {
    @Test
    public void validateEmployee() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickManagerButton();
        ManagerPage managerPage=new ManagerPage(driver);
        managerPage.CustomerInformation(driver,"Diana","Vanghelii","23224");
        Thread.sleep(2000);
        managerPage.OpenAccountInfo(driver,"Diana Vanghelii","Pound");
        Thread.sleep(2000);
        managerPage.ValidateCustomers();
        Thread.sleep(2000);
        driver.quit();





    }

}