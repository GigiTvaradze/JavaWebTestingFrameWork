package Section7TechniquestToAutomateWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class calendar {

    @Test
    public void testCalendar() {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        driver.findElement(By.linkText("Top Deals")).click();

        String monthNumber = "6";

        String date = "15";

        String year = "2027";

        String[] expectedList = {monthNumber, date, year};


        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();

        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber) - 1).click();

        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for (int i = 0; i < actualList.size(); i++) {

            System.out.println(actualList.get(i).getAttribute("value"));

            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }
    }
}
