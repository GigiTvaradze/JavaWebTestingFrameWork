package Section7TechniquestToAutomateWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class checkbox {
    WebDriver driver;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
    }

    @Test
    public void checkBoxes() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement checkbox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));

        if (!checkbox.isSelected()){
            checkbox.click();
        }
    }

    @Test
    public void multipleCheckBoxes(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("div[id='discount-checkbox'] input[type='checkbox']"));

        int checkBoxesCount= checkboxes.size();

        for (int i = 0; i < checkBoxesCount;i++) {
            for (WebElement checkbox : checkboxes){
                // Code to interact with each checkbox

                //checkboxes: This is a collection (like a List<WebElement>) containing all the checkboxes you want to iterate over.
                //WebElement checkbox: This declares a variable checkbox of type WebElement. In each iteration of the loop, this variable will hold the current element (i.e., one checkbox at a time) from the checkboxes list.
                //: (Colon): This is the separator in the enhanced for loop. It means "for each checkbox in checkboxes".
                if (!checkbox.isSelected()){
                checkbox.click();
                    Assert.assertTrue(checkbox.isSelected());
                }
            }
            break;
        }
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Quit");
        driver.quit();
    }
}
