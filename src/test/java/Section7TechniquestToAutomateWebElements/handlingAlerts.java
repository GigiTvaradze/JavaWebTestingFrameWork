package Section7TechniquestToAutomateWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Objects;

public class handlingAlerts {
    @Test
    public void HandlingAlerts(){
        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        By nameInputLocator = By.id("name");
        By alertBtnLocator = By.id("alertbtn");
        By confirmBtnLocator = By.id("confirmbtn");
        String text = "Test";

        WebElement inputName = driver.findElement(nameInputLocator);
        inputName.sendKeys(text);

        WebElement alertBtn = driver.findElement(alertBtnLocator);
        alertBtn.click();

        //you cant directly click on pop up because it is not HTML format
        String  alertText = driver.switchTo().alert().getText();

        if (Objects.equals(alertText, "Hello "+text+", share this practice page and share your knowledge")){
            driver.switchTo().alert().accept();
        }
        else {
            driver.quit();
        }

        //you switch your context to alert
        inputName.sendKeys(text);

        WebElement confirmBtn = driver.findElement(confirmBtnLocator);
        confirmBtn.click();

        driver.switchTo().alert().dismiss();
    }
}
