package Section13MiscellaneousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class brokenLinks {
    @Test(description = "broken Links")
    public void brokenLinksTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> linkList = driver.findElements(By.cssSelector("li[class='gf-li'] a"));


        for (WebElement link : linkList) {
            String url = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);
            softAssert.assertTrue(responseCode < 400, link.getText() + "is broken, with code: " + responseCode);
        }

        softAssert.assertAll();
    }


    @Test()
    public void brokenLinksTestAnswer() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Step 1 - IS to get all urls tied up to the links using Selenium

        //  Java methods will call URL's and gets you the status code

        //if status code >400 then that url is not working-> link which tied to url is broken

        //a[href*="soapui"]'

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            a.assertTrue(respCode < 400, "The link with Text" + link.getText() + " is broken with code" + respCode);
        }
        a.assertAll();
    }
}
