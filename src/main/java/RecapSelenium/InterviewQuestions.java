package RecapSelenium;

public class InterviewQuestions {
    /*
    1-What are the advantages and disadvantages of Selenium?
    Advantages:     -Free Source
                    -It supports multiple languages(Java, Phyton, C++, C#)
                    -Big Community
                    -Supports multiple browsers(chrome, ForeFox, Safari...)

    Disadvantages:  -You cannot automate ("Captcha, Pictures, Mobile Applications...)
                    -There is no direct call for the error report(support center/customer call
                    -It only automates Web Applications
                    -It doesn't have any system to generate report, so we integrate reports
                      TestNG report, Cucumber Report

    2-What type of testing can you automate in Selenium?
        -Smoke Testing      -Regression Testing     -Functional Testing(positive/negative scenarios)
    3-What are the test types that you cannot automate with selenium?

       -Performance testing
       -Manual Testing(captcha, pictures, Adhoc testing)
       -Non-functional testing(performance, stress testing, load testing)

    4-What is locator and what re the locator types? ******
        Locator is a way to find the elements from DOM(Development tool/page)
        We have different types of locator such as:
        -->ID           -->ClassName            -->Name            -->TagName
        -->LinkText     -->PartialLinkText      -->CSS             -->XPath

    5-How do you handle the dynamic Elements?(CVS)*****
    In my project I faced many dynamic elements and I use different ways to handle with:
        -->I use parent-child relationship to locate element
        -->I use different attributes which are not dynamic(changes)
        SHOW OFF-->I use special xpath types:
                -->Following-siblings
                -->Preceding-siblings
                -->Contains
                -->.=
                -->and condition

    6-What is the difference between driver.get() and driver.navigate.to()?**
        navigate.to() -->does not wait webElement(page) to be loaded totally.
                      -->have some methods: refresh, back, forward, to

        get()         -->it will wait for all the webElements to be loaded
                      -->does not have any methods
    7-What is the difference between driver.close() and driver.quit()?
        close()     -->it specifically closes the window that your driver is currently working on.

        quit()      -->it closes all the open pages from automation.

    8-What is XPATH? and can you tell me about the types of xpath? Which one do you use in your projects mostly?***
        -->Xpath is used to find the location of the elements on a webpage by using html structure
        -->Xpath is one of the ways to locate the webElement.(simple version)
        There are two types of xpath:

        -->Absolute Xpath-->It goes all the way from parent to child step by step(html/body/div/h1/button)
                         -->Starts with single slash(/)

        -->Relative Xpath-->It directly focuses on the child(location of th element) or parent-child(h1/button)

        In my projects, I mostly use the relative xpath because it directly focuses on the child which I need to locate
                        -->It saves a lot of time to not check all the parents of the child
                        -->Element is in Relative xpath way shorter than Absolute Xpath

    9-What is the difference between Relative and Absolute Xpath?
    Absolute Xpath:
    -->Goes from parent to child
    -->Has single slash(/) for the path
    -->Syntax is different

    Relative Xpath:
    -->Goes from parent to child or to the child directly
    -->Has double slash(//) for the path
    --Syntax is different

    10-How do you handle (static) drop down menu/dropdowns?
        In my projects I was handling static dropdown in different ways:
        *I would definitely check the tag of the location
        *If the tagName is "SELECT", I use Select select=new Select(Location of the WebElement)
        *If the tagName is NOT "SELECT", I  use locators to locate my elements and "SENDKEYS"
        *I can also use Action Class to click or Hover Over the element(Action action=new Action(driver)-->
            -->action.moveToElement(webElement).perform();

    11-Can you tell me some method that you use for Select Class?*
        In my project, I use Select Class to handle dropdowns.
        -->Select Class is a really useful to locate and find the elements and to be able to Select Class
        -->This element MUST HAVE "SELECT" TAG NAME>

        -->SelectByVisibleText()
        -->SelectByIndex()
        -->SelectByValue()

    12-What kind of Exceptions did you face in Selenium during automation?
        -->NoSuchElementException
        -->StaleElementReference
        -->NullPoint(driver and pages initialization)
        -->ElementIsNotInterceptedException(element might not be visible on the page(scroll down)
        -->ElementIsNotIntractable(element might not be visible on the page(scroll down)
        -->TimeOutException(Explicit and Fluent wait)
        -->NoSuchFrameException
        -->NoSuchWindowException
        -->UnhandledAlertException

    13-In what condition do you get StaleElementReferenceException? How do you handle it? *****
        There are couple reasons of getting this exception:
            **-->The element is not in the DOM(Development Structure/Tool)
            **-->The element is not updated yet
             *-->The element needs to be refreshed
        As a tester one of the top exceptions I face and struggle to handle is StaleElementReference.
        With my research I found that these 3 ways are really effective
        *****   1. I reinitialize the webElement/reassign the webElement
        Ex: WebElement element=driver.findElement(By.id("Diana"));
            element.click();//Stale element reference exception
            element=driver.findElement(By.id("Diana"));
            element.click();
        ***     2. I use Thread.sleep because some elements require a little more time to be updated,
        so we can wait with thread.sleep
        *       3. driver.navigate.refresh();

     14-How do you handle Alert?
        There are different types of alerts that I faced in my framework,
        can you please specify which one you are asking about?
        -->OS alert/pop-up--Operation System Alerts which we can not handle with Selenium.
         As much as i know, there is a robot class
        which handles it, but tbh(to be honest), I never used before.
        -->HTML alert/pop-up-->With Selenium you can find the element then take actions you want.
        Like click OK, Cancel, x button...etc
        -->JavaScript pop-up--> that we handle with the help of Alert Interface--> Mostly,
         I face pop-ups which come from JavaScript
        To be able to handle these pop-ups, I create an Object using Alert Interface and call the methods:
        Alert alert=driver.switchTo().alert();
            -->alert.accept();-->it clicks the "OK" button
            -->alert.dismiss();-->it clicks the :CANCEL" button
            -->alert.sendKeys();-->it send the key(text) to the JS pop-up
            -->alert.getText();-->it get the Text

      15-What do you know about Iframe? Can you tell me the types that you used before and how do you the iframe in Selenium?
        *Iframe is way to protect the data like advertisement, videos, documents... etc
        ***We cannot directly access the inside of the iframe because "Iframe is html inside of HTML"

        -->To be able to understand the data under the iframe:
        *I automate my element and when getting NoSuchElementException(If you believe everything is good with the element xpath)
        *I go tot the website and search for//frame or//iframe
        *Then I look up my element whether is under this iframe or not

        There are different types of iframes that I can handle:
        -->You have to switch your iframe to be able to access the data:
        driver.switchTo().frame(Name orID)-->Most common(99%)
        driver.switchTo().frame(WebElement)-->driver.findElement(By.xpath(//frame[@id="frame-1"])
        driver.switchTo().frame(index)-->not suggested since index numbers are changing often
        SHOW OFF:
        If you want I can give you more details about other methods for iframe like:
            -->driver.switchTo().parentFrame()-->which goes to the parent of the frame
            -->driver.switchTo().defaultContent()-->which goes directly to the Main HTML(all the eay to the top/main)

     16-What do you know about Actions class?
        Actions class is really useful for my framework since with action class I use Keyboard and Mouse actions
        Action actions=new Action(driver);
        ==>actions.
                -->moveByOffSet(x,y)-->it is going to find the element based on x and y locations
                -->doubleClick()-->it double clicks the element
                -->sendKeys()-->it sends the keys to the element, Keys.ENTER***
                -->contextClick()-->it right clicks the element
                -->clickAndHold()-->i clicks and holds the element
                -->release()-->it releases the element that is already clicked and hold
                -->dragAndDrop()-->it drags and drops the element
                -->moveElement()-->it hovers over the element
                -->click()-->it clicks the element
                -->scrollByAmount(x,y)-->it scrolls the page  on the x and y
       *****    -->perform()-->it performs actions method(WITHOUT THIS IT WILL NOT WORK)

       KEYBOARD ACTIONS:
            -->Keys.ENTER/RETURN-->it enters after sending keys
            -->Keys.ArrowUp/Down/Right/Left-->it goes in different directions on the page(Sliders and scrollPage)

    17-What is the difference between findElement and findElements?
        FindElement:                                                            FindElements:
        *driver.findElement(By.)        -->syntax is different      <--         *driver.findElements(By.)
        *returns the single WebElement  -->return type is different <--         *returns the List of Elements
        *Once it fails, it throws
        NoSuchElement exception         --> ExceptionType           <--         *It throws the empty list. No exception

    18-Can you tell me some driver and WebElement Element methods?

        -->  Driver Methods:                                                   -->  WebElement Methods:
  *get()-->goes to the website                                         *sendKeys()-->it sends the keys
  *navigate().to()-->goes to the website no waiting                    *click()-->it clicks the element
  *getTitle()-->gets the title                                         *getText()-->it gets the text
  *findElement/s()-->find the elements from webpage                    *clear()-->it clears the box
  *getCurrentUrl()-->it gets the url of the page                       *isDisplayed()-->it checks the element is visible
  *getPageSource()-->it gets the source of page(HTML)                  *isSelected()-->it checks the box/radio button is selected
  *manage().window().maximize()-->it maximize your web Browser         *submit()-->it clicks the submit button
  *manage().wait().implicitlyWait()-->it creates wait times            *getAttribute()-->it gets the value of any attribute
  *getWindowHandle/s-->it gets the id of the webpage                   *getCSSValue()-->it gets the CSS value of element(color)
  *switchTo().window-->it switches the window
  *switchTo().alert()-->it switches the alert
  *switchTo().frame()-->it switches the frame
  *quit()-->it closes the "ALL PAGES"
  *close()-->it closes the current page.

    19-What is the difference between check-box and radio-button?**

    CheckBox-->You cn click multiple boxes

    RadioButton-->You can choose only one

    20-what is the difference between isDisplayed, isSelected and isEnabled?

    All of the return a boolean condition:
    isDisplayed
    isSelected
    isEnabled




























     */
}
