package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class PracticeSelectAndLocators {
    /*
    Open this link - https://www.techlistic.com/p/selenium-practice-form.html
Enter first and last name (textbox).
Select gender (radio button).
Select years of experience (radio button).
Enter date.
Select Profession (Checkbox).
Select Automation tools you are familiar with (multiple checkboxes).
Select Continent (Select box).
Select multiple commands from a multi select box.
//If you can handle Upload image then try it or leave this step.
//Click on Download file link and handle the download file pop-up (leave it if you are beginner).
Click on Submit button.
Try your own logic and automate it without any help. If you still find it difficult to automate then follow reference links
     */
    @Test
    public void techlistic() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Diana");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Vanghelii");
        WebElement gender= driver.findElement(By.id("sex-0"));
        gender.click();
        WebElement yearsOfExperience= driver.findElement(By.xpath("//input[@value='3']"));
        yearsOfExperience.click();
        WebElement date= driver.findElement(By.id("datepicker"));
        date.sendKeys("08/16/2022");
        WebElement profession= driver.findElement(By.xpath("//input[@value='Automation Tester']"));
        profession.click();
        WebElement selenium= driver.findElement(By.xpath("//input[@value='Selenium Webdriver']"));
        selenium.click();
        WebElement continent= driver.findElement(By.xpath("//select[@id='continents']"));
        BrowserUtils.selectBy(continent, "North America", "text");
        continent.sendKeys("North America");
        WebElement seleniumCommands= driver.findElement(By.xpath("//select[@id='selenium_commands']"));//OR by Id="selenium commands"
        BrowserUtils.selectBy(seleniumCommands, "Browser Commands", "text");
        BrowserUtils.selectBy(seleniumCommands, "Switch Commands", "text");
        WebElement submitButton= driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        /*
        @Test
public void login(){
    WebDriverManager.chromedriver();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
    WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
    firstName.sendKeys("Mustafae");
    WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
    lastName.sendKeys("Obaiwd");
    WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
    email.sendKeys("mostafa23on@gmail.com");
    WebElement phoneNumber =driver.findElement(By.xpath("//input[@name='telephone']"));
    phoneNumber.sendKeys("4738482302439");
    WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
    password.sendKeys("kenfuejfu3");
    WebElement confirm = driver.findElement(By.xpath("//input[@name='confirm']"));
    confirm.sendKeys("kenfuejfu3");
    WebElement yes = driver.findElement(By.xpath("//label//input[@name='newsletter']"));
    yes.click();
    WebElement checkBox = driver.findElement(By.xpath("//input[@name='agree']"));
    checkBox.click();
    WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
    button.click();

    WebElement massage = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
    String actualMassage = massage.getText();
    String expectedMassage= "Your Account Has Been Created!";
    Assert.assertEquals(actualMassage,expectedMassage);
         */
    }
    //HOMEWORK TASK:

    @Test
    public void ninjaTask() throws InterruptedException {
        /*
1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
2-Fill all the boxes
3-click Yes radio button for subscription
4-Click privacy button
5-Click continue button
6-Validate Account is created header

NOTE:To be able to see if account is created for you last run make sure you have a different username
just add ahmet1,ahmet2 like that everytime for validation.(ASSERT)
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Diana01");
        Thread.sleep(1000);
        WebElement lastName= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Vanghelii01");
        Thread.sleep(1000);
        WebElement email= driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("dianavanghelii01@yahoo.com");
        Thread.sleep(1000);
        WebElement telephone= driver.findElement(By.xpath("//input[@name='telephone']"));
        telephone.sendKeys("987-654-3210");
        Thread.sleep(1000);
        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("techt0rial22");
        Thread.sleep(1000);
        WebElement repeatPassword= driver.findElement(By.xpath("//input[@name='confirm']"));
        repeatPassword.sendKeys("techt0rial22");
        Thread.sleep(1000);
        WebElement subscribe= driver.findElement(By.xpath("//label[@class='radio-inline']//input[@value='1']"));
        subscribe.click();
        Thread.sleep(1000);
        WebElement privacyPolicy= driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicy.click();
        Thread.sleep(1000);
        WebElement continueButton= driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        WebElement message= driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actualMassage = message.getText().trim();
        String expectedMassage= "Your Account Has Been Created!";
        Assert.assertEquals(actualMassage,expectedMassage);
        Thread.sleep(2000);
        driver.quit();
    }
}
