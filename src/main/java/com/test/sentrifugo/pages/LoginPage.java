package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
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
    public  LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@id='username']")
    WebElement username;
    @FindBy(name="password")
    WebElement password;
    @FindBy(id="loginsubmit")
    WebElement loginButton;

    @FindBy(id="usernameerror")
    WebElement usernameError;
    @FindBy(id="pwderror")
    WebElement passwordError;
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();

    }
    public String usernameErrorMessage(){
        return BrowserUtils.getText(usernameError);
    }
    public String passwordErrorMessage(){
        return BrowserUtils.getText(passwordError);
    }
    public String usernameErrorColor(){
        return usernameError.getCssValue("color");
    }
    public String passwordErrorColor(){
        return  passwordError.getCssValue("color");
    }
}
