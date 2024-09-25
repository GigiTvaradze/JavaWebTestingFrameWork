package Section15SeleniumLatestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class relativeLocators {

    /*
    These 5 relative locators in Selenium 4 are:
above()  - above() is used to locate the web element(s) just above the specified element. > above(By locator)
below() - below() is used to locate the web element(s) just below the specified element. > below(By locator)
toLeftOf() - It is used to locate the web element(s) present on the left of the specified element. > toLeftOf(By locator)
toRightOf() - It is used to locate the web element(s) present on the right of the specified element. > toRightOf(By locator)
                                                                                                       toRightOf(WebElement element)
near() - It is used to locate the web element(s) located at approximately 50 pixels away from the specified element. >  near(By locator)
                                                                                                                        near(WebElement element)
                                                                                                                        near(By locator, int atMostDistanceInPixels)
                                                                                                                       near(WebElement element, int atMostDistanceInPixels)
     */

    @Test
    public void relativeLocatorsNewFeature(){
        /*
        WebElement element = driver.findElement(By.cssSelector(""));
        driver.findElement(with(By.tagName("li")).above(element)).getText();
        driver.findElement(with(By.tagName("li")).below(element));
        driver.findElement(with(By.tagName("li")).toLeftOf(element));
        driver.findElement(with(By.tagName("li")).toRightOf(element));
        driver.findElement(with(By.tagName("li")).near(element));
         */

        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));

        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));

        driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

        WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        WebElement rdb = driver.findElement(By.id("inlineRadio1"));

        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
    }
}
