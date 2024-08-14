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
import java.util.List;

public class autoSuggestiveDropdowns {
    WebDriver driver;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
    }

    @Test
    public void autoSuggestiveDropdowns() throws InterruptedException {
        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement autoSuggest = driver.findElement(By.id("autosuggest"));
        autoSuggest.sendKeys("Ind");

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li[class='ui-menu-item'] a")));
        //find multiple elements on the web page based on the provided CSS selector.

        for(WebElement option :options)
        //This for loop iterates through each WebElement in the options list.
        {
            if(option.getText().equalsIgnoreCase("India"))
            //option.getText(): Retrieves the text content of the current WebElement.
            //equalsIgnoreCase("India"): Compares the text content to the string "India", ignoring case differences (i.e., it matches "india", "INDIA", etc.).
            {
                option.click();
                break;
                //option.click(): Clicks the WebElement that matches the text "India".
                //break: Exits the loop once the desired option is found and clicked. This prevents further unnecessary checks or clicks.
            }
        }
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Quit");
        driver.quit();
    }
}
