package Section15SeleniumLatestFeatures;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class takingWebElementPartialScreenshot {
    private static WebDriver driver;

    @Test(description = "Capture ScreenShot of WebElement")
    public void invokingMultipleWindows() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        driver = new ChromeDriver();

        //navigate to https://rahulshettyacademy.com/angularpractice/
        hitUrl("https://rahulshettyacademy.com/angularpractice/");

        //fill the "name" field with the first course name available at https://rahulshettyacademy.com

        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it= handles.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();

        switchToWindow(childWindowId);
        hitUrl("https://rahulshettyacademy.com");

        String title =driver.getTitle();

        switchToWindow(parentWindowId);

        WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
        name.sendKeys(title);

        File file =name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("logo.png"));

        driver.quit();

    }
    public static void hitUrl(String url){driver.get(url);}
    public static void switchToWindow(String windowId){
        driver.switchTo().window(windowId);
    }
}
