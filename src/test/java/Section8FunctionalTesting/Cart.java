package Section8FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Cart {
    @Test
    public void cart(){
        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

        for (WebElement webElement : product) {
            String name = webElement.getText();
            if (name.contains("Cucumber")) {
                driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
                break;
            }
        }
    }
}
