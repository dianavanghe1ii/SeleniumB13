package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/diana/Downloads/Techtorialhtml.html");
        //ID LOCATOR
        WebElement header=driver.findElement(By.id("techtorial1")); //it will find elements with specific
        String actualHeader=header.getText();//gettext() method -->gets the text and return String
        String expectedHeader="Techtorial Academy";
        System.out.println(actualHeader);
        if (actualHeader.equals(expectedHeader)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement paragraph=driver.findElement(By.id("details2"));
        //System.out.println(paragraph.getText());
        String actualParagraph=paragraph.getText();
        String expectedParagraph="To create your account, we'll need some basic information about you. " +
                "This information will be used to send reservation confirmation emails," +
                " mail tickets when needed and contact you if your travel arrangements change." +
                " Please fill in the form completely.";
        System.out.println(actualParagraph);
        if (actualParagraph.equals(expectedParagraph)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        //Name Locator

        WebElement firstNameBox=driver.findElement(By.name("firstName"));
        firstNameBox.sendKeys("Diana");//sendKeys() method send the data that you want.
        WebElement lastNameBox=driver.findElement(By.name("lastName"));
        lastNameBox.sendKeys("Vanghelii");
        WebElement phoneBox=driver.findElement(By.name("phone"));
        phoneBox.sendKeys("56357657567");
        WebElement emailBox=driver.findElement(By.name("userName"));
        emailBox.sendKeys("diana.vanghelii@yahoo.com");
        WebElement addressBox=driver.findElement(By.name("address1"));
        addressBox.sendKeys("123 broad st");
        WebElement cityBox=driver.findElement(By.name("city"));
        cityBox.sendKeys("Chicago");
        WebElement stateBox=driver.findElement(By.name("state"));
        stateBox.sendKeys("IL");
        WebElement postalCodeBox=driver.findElement(By.name("postalCode"));
        postalCodeBox.sendKeys("60657");

        //Class Name Locator
        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        //WebElement is displayed and selected method?
        WebElement javaBox= driver.findElement(By.id("cond1")); //I have a box now
        System.out.println(javaBox.isDisplayed());//true
        if (javaBox.isDisplayed()){
            javaBox.click();
            System.out.println(javaBox.isSelected());//true
        }else {
            System.out.println("box is not displayed");
        }
        WebElement testngBox= driver.findElement(By.id("cond3"));
        System.out.println(testngBox.isDisplayed());
        if (testngBox.isDisplayed()){
            testngBox.click();
            System.out.println(testngBox.isSelected());
        }else {
            System.out.println("box is not displayed");
        }
        WebElement cucumberBox= driver.findElement(By.id("cond4"));
        System.out.println(cucumberBox.isDisplayed());
        if (cucumberBox.isDisplayed()){
            cucumberBox.click();
            System.out.println(cucumberBox.isSelected());
        }else {
            System.out.println("box is not displayed");
        }

    }
}
