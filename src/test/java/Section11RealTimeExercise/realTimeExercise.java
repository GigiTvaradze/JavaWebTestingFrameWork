package Section11RealTimeExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class realTimeExercise {

    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Give me the count of links on the page.
        //2. Count of footer section-

        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerdriver=driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope

        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3-
        WebElement coloumndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumndriver.findElements(By.tagName("a")).size());

        //4- click on each link in the coloumn and check if the pages are opening-
        for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
        {

            String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);

            coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            Thread.sleep(5000L);

        }
        // opens all the tabs
        Set<String> abc=driver.getWindowHandles();//4
        Iterator<String> it=abc.iterator();

        while(it.hasNext())
        {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
        driver.quit();
    }
}
