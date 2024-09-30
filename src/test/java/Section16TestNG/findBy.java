package Section16TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class findBy {
    @FindBy(id = "UserName")
    private WebElement userName;
    @FindBy(id = "UserPassword")
    private WebElement userPassword;

    public void LoginPage(String Name, String Password){
        userName.sendKeys(Name);
        userPassword.sendKeys(Password);
    }
}
