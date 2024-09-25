import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class istqbExamBookingE2E {
    @Test
    public void testerFoundationLevelExamBooking() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.gasq.org/en/home.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By certificationDropdownLocator = By.cssSelector("li[class='submenu sibling first dropdown'] a[title='Certification']");
        By dropdownMenuListLocator = By.cssSelector("ul[class='ul'] li a");
        By primaryTopicLocator = By.cssSelector(".content-title");  // Update this to the correct selector

        // Step 1: Click on "Certification" Dropdown
        wait.until(ExpectedConditions.elementToBeClickable(certificationDropdownLocator)).click();

        // Step 2: Choose "Exam Booking"
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownMenuListLocator));

        List<WebElement> dropdownMenuList = driver.findElements(dropdownMenuListLocator);
        boolean found = false;

        for (WebElement dropdownList : dropdownMenuList) {
            if (dropdownList.getText().equals("Exam Booking")) { // Check the visible text instead of attribute
                dropdownList.click();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Exam Booking option not found!");
            driver.quit();
            return; // Exit the test early if not found
        }

        // Step 3: Wait for the target page to load after clicking "Exam Booking"
        wait.until(ExpectedConditions.visibilityOfElementLocated(primaryTopicLocator));

        // Step 4: Assert that we land on the correct page
        String primaryTopicText = driver.findElement(primaryTopicLocator).getText();
        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Page Title: " + title);
        System.out.println("Current URL: " + currentUrl);

        Assert.assertEquals(primaryTopicText, "Exam Booking", "Primary Topic Text does not match.");
        Assert.assertEquals(title, "Exam Booking - GASQ", "Page title does not match.");
        Assert.assertEquals(currentUrl, "https://www.gasq.org/en/certification/exam-booking.html", "URL does not match.");

        driver.quit();
    }
}
