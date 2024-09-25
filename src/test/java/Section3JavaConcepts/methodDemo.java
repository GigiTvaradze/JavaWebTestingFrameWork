package Section3JavaConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class methodDemo {
    WebDriver driver = new ChromeDriver();
    By loginButtonLocator = By.id("");

    public void clickOnButton(){
        driver.findElement(loginButtonLocator);
    }

    public String getData(){
        String helloWorld = "Hello World !";
        return helloWorld ;
    }
}
