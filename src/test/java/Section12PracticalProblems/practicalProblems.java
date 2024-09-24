package Section12PracticalProblems;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class practicalProblems {
    @Test(description = "scrolling with JavascriptExecutor")
    public void scrollWithJavascriptExecutor (){
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//        WebElement scroll = driver.findElement(By.cssSelector("div.totalAmount"));
//        WebElement mouseHoverScroll = driver.findElement(By.id("mousehover"));
//        Actions actions = new Actions(driver);
//        actions.scrollToElement(scroll);
//        actions.moveToElement(mouseHoverScroll).build().perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Window scroll
        js.executeScript("window.scrollBy(window.scrollBy(0,30))");
        //Table scroll
        js.executeScript("document.querySelector('.tableFixHead').scrollTop");
    }
}
