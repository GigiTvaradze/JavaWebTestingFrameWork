package Section13MiscellaneousTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MaximizingWindowDeletingCookies {
    @Test()
    public void maximizingWindowDelCookies() {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //MaximizingWindow
        driver.manage().window().maximize();
        //DeletingCookies
        driver.manage().deleteAllCookies();

        driver.get("https://expired.badssl.com/");
    }
}
