package Section7TechniquestToAutomateWebElements.DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class dynamicDropdowns {
    WebDriver driver;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
    }

    @Test
    public void dynamicDropdowns(){
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
        driver.get("https://www.spicejet.com/");

        driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();
        WebElement flightFrom = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@value='BLR']")));
        flightFrom.click();

        driver.findElement(By.cssSelector("div[data-testid='to-testID-destination']")).click();
        WebElement flightTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@value='MAA'])[2]")));
        flightTo.click();
    }

    @Test(description = "Parent-Child relationship locator to identify the objects Uniquely. without index")
    public void dynamicDropdowns1(){
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
        driver.get("https://www.spicejet.com/");

        driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();
        WebElement flightFrom = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@value='BLR']")));
        flightFrom.click();

        //Parent-Child
        driver.findElement(By.cssSelector("div[data-testid='to-testID-destination']")).click();
        WebElement flightTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")));
        flightTo.click();
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Quit");
        driver.quit();
    }
}