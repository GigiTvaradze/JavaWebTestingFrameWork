import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class assignmentN1 {

    @Test
    public void assignmentN1(){
        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked

        WebElement checkBox1 =  driver.findElement(By.cssSelector("input[id='checkBoxOption1']"));
        Assert.assertFalse(checkBox1.isSelected());
        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected());
        checkBox1.click();
        Assert.assertFalse(checkBox1.isSelected());

        //How to get the Count of number of check boxes present in the page
        List<WebElement> checkBoxes =  driver.findElements(By.cssSelector("div[id='checkbox-example'] input[type='checkbox']"));
        Assert.assertEquals(checkBoxes.size(),3);
    }
}
