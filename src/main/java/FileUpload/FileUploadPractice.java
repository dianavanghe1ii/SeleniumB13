package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\diana\\OneDrive\\Desktop\\Techtorial\\usa.png");
        WebElement update = driver.findElement(By.id("file-submit"));
        update.click();
        WebElement message = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(BrowserUtils.getText(message).equals("File Uploaded!"));

    }

    /*
1-Navigate to the "https://demo.guru99.com/test/upload/"
2-upload the file
3-Click the box of I accept terms of service
4-Click submit file
5-Validate the message "1 file has been successfully uploaded."
6-Close the webpage
*/
    @Test
    public void homework() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFileButton= driver.findElement(By.id("uploadfile_0"));
        chooseFileButton.sendKeys("C:\\Users\\diana\\OneDrive\\Desktop\\fall.png");
        WebElement checkBox= driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        Thread.sleep(1000);
        WebElement submitButton= driver.findElement(By.id("submitbutton"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement message= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(BrowserUtils.getText(message).equals("1 file\n" +
                "has been successfully uploaded."));
        Thread.sleep(2000);
        driver.close();

    }


}
