package Section7TechniquestToAutomateWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class validatingElementsState {

    @Test(description = "Validating if UI Elements are disabled or enabled with Attributes")
    public void validatingElementsState() throws InterruptedException {

        By roundTripRadioButtonLocator = By.cssSelector("div[data-testid='round-trip-radio-button']");

        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Style opacity changing from null to 1 when enabling return date
        if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")))
                .getAttribute("style")
                .contains("opacity: 1")){
            System.out.println("Button is enabled");
        } else  {
            System.out.println("Button is disabled");
        }

        driver.findElement(roundTripRadioButtonLocator).click();

        if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")))
                .getAttribute("class")
                .contains("r-14lw9ot")){
            System.out.println("Button is enabled");
        } else  {
            System.out.println("Button is disabled");
        }

        driver.quit();
    }
}
