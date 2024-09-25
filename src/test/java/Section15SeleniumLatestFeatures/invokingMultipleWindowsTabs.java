package Section15SeleniumLatestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class invokingMultipleWindowsTabs {
    private static WebDriver driver;

    @Test(invocationCount = 5)
    public void invokingMultipleWindows() {
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

        driver.findElement(By.cssSelector("input[name='name']")).sendKeys(title);

        driver.quit();

    }

    public static void hitUrl(String url){
        driver.get(url);
    }

    public static void switchToWindow(String windowId){
        driver.switchTo().window(windowId);
    }
}