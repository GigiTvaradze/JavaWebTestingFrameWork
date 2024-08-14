import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class assignmentN2 {

    @Test
    public void assignmentN2(){
        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.cssSelector("div.form-group input[name='name']")).sendKeys("Test");
        driver.findElement(By.cssSelector("div.form-group input[name='email']")).sendKeys("Test@email.com");
        driver.findElement(By.cssSelector("div.form-group input[placeholder='Password']")).sendKeys("Test@Test1!");

        WebElement checkbox = driver.findElement(By.id("exampleCheck1"));
        Assert.assertFalse(checkbox.isSelected());
        if (!checkbox.isSelected()){
            checkbox.click();
        }

        WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdowns = new Select(dropdown);
        dropdowns.selectByVisibleText("Male");

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("div[class='form-group'] input.form-check-input"));
        Assert.assertEquals(checkBoxes.size(),3);

        WebElement inlineRadio3 = driver.findElement(By.id("inlineRadio3"));
        Assert.assertFalse(inlineRadio3.isEnabled());

        for (WebElement checkBoxx : checkBoxes){
            checkBoxx.click();
        }

        driver.findElement(By.cssSelector("div[class='form-group'] input[type='date']")).sendKeys("08/25/2024");

        driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();

        WebElement alertText = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(alertText.getText(),"×\n" +
                "Success! The Form has been submitted successfully!.");

        //Defect: in text × symbol is stuck
    }
}
