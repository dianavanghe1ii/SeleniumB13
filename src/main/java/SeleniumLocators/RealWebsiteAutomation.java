package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealWebsiteAutomation {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul
5-Click apply for hospital admission box
6-Healhcare program 'Medicaid'
7-Visit date should be provided
8-Put your command for this box
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Print out the headers and values(only values) on your console.
11)Click go to homepage and print out url
12)Driver.quit or close.

 */
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        WebDriver driver= new ChromeDriver();
//        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
//        WebElement appointment= driver.findElement(By.id("btn-make-appointment"));
//        appointment.click();
//        WebElement username= driver.findElement(By.xpath("//input[@id='txt-username']"));
//        username.sendKeys("John Doe");
//        WebElement password=driver.findElement(By.xpath("//input[@id='txt-password']"));
//        password.sendKeys("ThisIsNotAPassword");
//        WebElement logIn= driver.findElement(By.id("btn-login"));
//        logIn.click();
//        WebElement facility= driver.findElement(By.xpath("//select[@id='combo_facility']"));
//        facility.sendKeys("");
//
//        WebElement admissionBox=driver.findElement(By.xpath("//input[@type='checkbox']"));
//        admissionBox.click();
//        WebElement medicaid=driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
//        medicaid.click();
//        WebElement date= driver.findElement(By.xpath("..input[@id='"));
//        date.sendKeys("11/08/2022");
//        WebElement comment= driver.findElement(By.xpath("//textarea[@name='comment']"));


        /*
          /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul
5-Click apply for hospital admission box
6-Healthcare program 'Medicaid'
7-Visit date should be provided
8-Put your command for this box
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Print out the headers and values(only values) on your console.
11)Click go to homepage and print out url
12)Driver.quit or close.
 */
        public static void main(String[] args) {
            WebDriver driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            WebElement makeAppointment=driver.findElement(By.id("btn-make-appointment"));
            makeAppointment.click();
            WebElement userName=driver.findElement(By.xpath("//input[@id='txt-username']"));
            userName.sendKeys("John Doe");
            WebElement passWord=driver.findElement(By.xpath("//input[@id='txt-password']"));
            passWord.sendKeys("ThisIsNotAPassword");
            WebElement loginButton=driver.findElement(By.id("btn-login"));
            loginButton.click();
            WebElement facility=driver.findElement(By.xpath("//select[@id='combo_facility']"));
            facility.sendKeys("Hongkong CURA Healthcare Center");
            WebElement box=driver.findElement(By.name("hospital_readmission"));
            if(box.isDisplayed()&&!box.isSelected()){
                box.click();
            }else{
                System.out.println("box is not displayed");
            }
            WebElement radioButton=driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
            radioButton.click();
            WebElement date=driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
            date.sendKeys("11/08/2022");
            WebElement comment=driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
            comment.sendKeys("I love automation");
            WebElement bookAppn=driver.findElement(By.xpath("//button"));
            bookAppn.click();
            WebElement visitDate=driver.findElement(By.xpath("//p[.='11/08/2022']"));
            System.out.println("Visit Date: "+visitDate.getText().trim());
            WebElement facilityValidation=driver.findElement(By.xpath("//p[contains(text(),'Hongkong')]"));
            System.out.println("Facility: "+facilityValidation.getText().trim());

    }
}
