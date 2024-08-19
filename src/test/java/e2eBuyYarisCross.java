import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class e2eBuyYarisCross {
    @Test
    public void e2eBuyYarisCross(){
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        driver.get("https://www.toyota.ge/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();


        WebElement carsNavigationItemLocator = driver.findElement(By.cssSelector("a[data-gt-label='level1:ავტომობილები']"));
        WebElement newCarNavigationItemLocator = driver.findElement(By.cssSelector("a[data-gt-label='level2:/content/toyota/georgia/ka/new-cars.html']"));

        actions.moveToElement(carsNavigationItemLocator).click();

        actions.moveToElement(newCarNavigationItemLocator).perform();

        WebElement yarisCross = driver.findElement(By.cssSelector("a[data-model-name='Yaris Cross']"));


        actions.scrollToElement(yarisCross).perform();

    }
}
