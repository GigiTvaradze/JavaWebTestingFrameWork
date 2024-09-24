import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class assignmentN8 {
    @Test
    public void assignment() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaclickacademy.com/practice.php");

        driver.findElement(By.id("autocomplete")).sendKeys("Unit");

        Thread.sleep(1000);
        List<WebElement> suggestionList = driver.findElements(By.cssSelector("li.ui-menu-item"));

        for (WebElement suggestion : suggestionList) {
            if (suggestion.getText().equals("United States (USA)")) { // Check if the suggestion is "United States (USA)"
                suggestion.click();
                break;
            }
        }
        Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value"),"United States (USA)");
    }


    @Test
    public void assignmentAnswer() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaclickacademy.com/practice.php");

        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(2000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
    }
}
