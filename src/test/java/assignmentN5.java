import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class assignmentN5 {
    @Test
    public void sad(){
        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> list = driver.findElements(By.cssSelector("li a"));
        for (WebElement webElement : list) {
            String name = webElement.getText();
            if (name.contains("Nested Frames")) {
                webElement.click();
                break;
            }
        }

        WebElement framesetMiddle = driver.findElement(By.cssSelector("frame[name='frame-top']"));
        driver.switchTo().frame(framesetMiddle);

        WebElement middleFrame = driver.findElement(By.cssSelector("frame[name='frame-middle']"));
        driver.switchTo().frame(middleFrame);

        String content = driver.findElement(By.id("content")).getText();
        Assert.assertEquals(content,"MIDDLE");

        driver.quit();
    }
}
