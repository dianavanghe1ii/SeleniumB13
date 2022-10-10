package MentoringWithAhmet.com.test.Bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagerPage {
     /*
1-Navigate to the website https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
2-Click Bank Manager Login
3-Click Add Customer
4-Fill the blanks and click add customer button
5-Get the text from pop-up and VALIDATE and click OK
6-Click Open Account
7-Choose your name from the list
8-Choose any currency you want from list
9-Get the text from pop-up and VALIDATE and click OK
10-Click Customers Button
11-Validate your firstname,lastName,PostCode and Account Number
12-driver.quit
13-Proud of yourself
 */

    public ManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement addButton;
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;

    @FindBy(id="userSelect")
    WebElement customerName;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyChoice;

    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;
    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersButton;
    @FindBy(xpath = "//table//tbody//tr[@class='ng-scope'][6]//td")
    List<WebElement> newCustomersInfo;

    public void CustomerInformation(WebDriver driver,String firstName,String lastName,String postCode) throws InterruptedException {
        addCustomer.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        addButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Customer added successfully with customer id :6");
        alert.accept();
        Thread.sleep(2000);
    }

    public void OpenAccountInfo(WebDriver driver, String name, String currency ) throws InterruptedException {
        openAccountButton.click();
        BrowserUtils.selectBy(customerName,"Diana Vanghelii","text");
        BrowserUtils.selectBy(currencyChoice,"Pound","text");
        processButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Account created successfully with account Number :1016");
        alert.accept();
    }
    public void ValidateCustomers() throws InterruptedException {
        customersButton.click();
        Thread.sleep(2000);
        List<String> expectedCustomerInformation= Arrays.asList("Diana","Vanghelii","23224","1016","Delete");
        List<String> actualCustomerInformation=new ArrayList<>();
        for (int i=0; i<newCustomersInfo.size(); i++){
            actualCustomerInformation.add(newCustomersInfo.get(i).getText().trim());
        }
        Assert.assertEquals(actualCustomerInformation,expectedCustomerInformation);

    }
}
