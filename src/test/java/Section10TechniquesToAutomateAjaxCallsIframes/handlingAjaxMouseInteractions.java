package Section10TechniquesToAutomateAjaxCallsIframes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class handlingAjaxMouseInteractions{

    @Test
    public void handlingAjaxInteractions (){
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']")))
                .build()
                .perform();

        actions.moveToElement(driver.findElement(By.cssSelector("")))
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("Monitor")
                .doubleClick()
                .keyDown(Keys.BACK_SPACE)
                .build()
                .perform();
    }

    @Test(description = "copy email from child window and past to parent window")
    public void windowHandle(){
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();

        //Getting Window Handles: Retrieves all the window handles opened by the WebDriver as a Set of String objects.
        //Each window handle is a unique identifier for an open window.
        Set<String> windows = driver.getWindowHandles();

        //Iterating through Window Handles:
        Iterator<String> it =windows.iterator();

        //Identifying the Parent and Child Windows:
        //Assigns the first window handle from the iterator to parentId (the parent window).
        //Assigns the second window handle from the iterator to childId (the child window).
        String parentId = it.next();
        String childId = it.next();

        //Switching to the Child Window:
        driver.switchTo().window(childId);

        String email = driver.findElement(By.linkText("mentor@rahulshettyacademy.com")).getText();
        Assert.assertEquals(email,"mentor@rahulshettyacademy.com");

        //Switching Back to the Parent Window:
        driver.switchTo().window(parentId);

        driver.findElement(By.id("username")).sendKeys(email);
    }

    @Test()
    public void handleFrames() {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");


    }

}
