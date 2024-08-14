package Section7TechniquestToAutomateWebElements.DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class staticDropDowns {
    WebDriver driver;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
    }

    @Test
    public void staticDropDownsTst(){
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(100));
        driver.get("https://www.spicejet.com/");

        WebElement clickOnGuest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='guest-submit-btn']")));
        clickOnGuest.click();

        WebElement dropdownButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='home-page-travellers']")));
        dropdownButton.click();

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.cssSelector("div[data-testid='Adult-testID-plus-one-cta']")).click();
        }

        driver.findElement(By.cssSelector("div[data-testid='home-page-travellers']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div[data-testid='home-page-travellers']")).getText(),"3 Adults");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Quit");
        driver.quit();
    }
}
