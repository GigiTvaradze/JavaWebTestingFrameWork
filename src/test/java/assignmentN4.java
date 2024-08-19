import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class assignmentN4 {
    @Test
    public void assignmentN4(){
        System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> list = driver.findElements(By.cssSelector("li a"));
        for (WebElement webElement : list) {
            String name = webElement.getText();
            if (name.contains("Multiple Windows")) {
                webElement.click();
                break;
            }
        }
        Assert.assertEquals(driver.findElement(By.cssSelector("div h3")).getText(),"Opening a new window");

        driver.findElement(By.cssSelector("div.example a[target='_blank']")).click();

        //Retrieving All Window Handles
        //Each window or tab that the WebDriver opens during a browser session is assigned a unique handle.
        //This line calls the getWindowHandles() method on the driver object, which returns a Set<String> containing the unique identifiers (handles) of all the windows currently opened by the WebDriver instance.
        Set<String> windowHandles = driver.getWindowHandles();

        //This line creates an Iterator<String> object from the Set of window handles. The iterator() method returns an iterator that can be used to loop through the elements in the Set.
        //The Set interface does not maintain any particular order, so using an iterator allows us to access each window handle in the order they were retrieved, one by one.
        Iterator<String> iterator= windowHandles.iterator();

        //Storing the Parent Window Handle:
        String parentId = iterator.next();
        //Storing the Child Window Handle:
        String childId = iterator.next();

        //Switching to the Child Window:
        driver.switchTo().window(childId);
        String childWindowText = driver.findElement(By.cssSelector("div.example h3")).getText();
        Assert.assertEquals(childWindowText,"New Window");

        driver.switchTo().window(parentId);

        String parentWindowText = driver.findElement(By.cssSelector("div.example h3")).getText();
        Assert.assertEquals(parentWindowText,"Opening a new window");
    }
}
