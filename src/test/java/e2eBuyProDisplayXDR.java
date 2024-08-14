import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class e2eBuyProDisplayXDR {


    //Step1 :  hit apple page
    //Step2 :  hover "Mac" Element
    //Step3 :  click "Displays" , Assert if correctly redirected on page
    //Step4 :  Scroll to "Buy Pro Display XDR" and click.  Assert if correctly redirected on page
    @Test(invocationCount=2)
    public void buyProDisplayXDR() {

        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");

        By macElementLocator = By.cssSelector("div[data-analytics-element-engagement='globalnav hover - mac']");
        By displayLocator = By.cssSelector("a[data-analytics-title='displays']");
        By displayPageLocator = By.cssSelector("h1.typography-hero-headline");
        By buyProDisplayXdrDisplayLocator = By.cssSelector("a[data-analytics-title='buy pro display xdr']");
        By purchaseLocator = By.cssSelector("h1.fwl");
        By standardGlassLocator = By.xpath("(//label[@class='form-selector-label'])[1]");


        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://www.apple.com/");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement macElement = driver.findElement(macElementLocator);
        action.moveToElement(macElement).perform();
        wait.until(ExpectedConditions.elementToBeClickable(displayLocator)).click();

        Assert.assertEquals(driver.findElement(displayPageLocator).getText(),"Displays");
        Assert.assertEquals(driver.getTitle(),"Displays - Apple");

        WebElement buyProDisplayXdrDisplay = driver.findElement(buyProDisplayXdrDisplayLocator);
        action.scrollToElement(buyProDisplayXdrDisplay);
        buyProDisplayXdrDisplay.click();

        System.out.println(driver.findElement(purchaseLocator).getText());
        Assert.assertEquals(driver.findElement(purchaseLocator).getText(),"Buy Pro Display XDR");
        //Defect
        //Expected :Buy Pro Display XDR
        //Actual   :
        Assert.assertEquals(driver.getTitle(),"Buy Pro Display XDR - Apple");


        driver.findElement(standardGlassLocator).click();
    }
    @AfterMethod
    public void quit(){
        WebDriver driver = new ChromeDriver();
        driver.close();
    }
}
