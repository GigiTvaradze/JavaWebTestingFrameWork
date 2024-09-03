import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class assignmentN6 {
    @Test
    public void assignmentN6() {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1: check Checkbox and print text
        WebElement check = driver.findElement(By.cssSelector("label[for='bmw']"));
        String checkName = check.getText();
        System.out.println(checkName);
        driver.findElement(By.cssSelector("label[for='bmw'] #checkBoxOption1")).click();
        driver.findElement(By.cssSelector("select[id='dropdown-class-example']")).click();

        List<WebElement> dropdown = driver.findElements(By.cssSelector("select[id='dropdown-class-example'] option"));

        for (int i = 0; i < dropdown.size(); i++) {
            String name = dropdown.get(i).getText();
            if (name.contains(checkName)) {
                dropdown.get(i).click();
                break;
            }
        }

        driver.findElement(By.id("name")).sendKeys(checkName);
        driver.findElement(By.id("alertbtn")).click();

        String whatIs = driver.switchTo().alert().getText();
        String mustBe = "Hello " + checkName + ", share this practice page and share your knowledge";
        Assert.assertEquals(whatIs, mustBe);
        driver.switchTo().alert().accept();
    }
}
