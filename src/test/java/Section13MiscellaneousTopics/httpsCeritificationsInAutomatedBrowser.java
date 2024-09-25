package Section13MiscellaneousTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Arrays;

public class httpsCeritificationsInAutomatedBrowser {

    @Test(description = "ChromeOptions > setAcceptInsecureCerts(true)")
    public void httpCertification() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);

        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://expired.badssl.com/");
    }

    @Test(description = "ChromeOptions > add extensions : addExtensions(file path)")
    public void chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);

        //block pop-up windows
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://expired.badssl.com/");
    }
}
