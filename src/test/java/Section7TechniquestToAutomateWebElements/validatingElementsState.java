package Section7TechniquestToAutomateWebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class validatingElementsState {

    @Test(description = "Validating if UI Elements are disabled or enabled with Attributes")
    public void validatingElementsState(){

        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


    }
}
