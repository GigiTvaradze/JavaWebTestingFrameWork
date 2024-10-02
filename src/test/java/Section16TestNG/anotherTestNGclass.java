package Section16TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

public class anotherTestNGclass {

    private WebDriver driver;

    @Test(dataProvider = "data")
    @Parameters({"username","Password"})
    public void demo(String username , String Password, String homiesName , String year){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");

        findBy findBy = new findBy();
        findBy.LoginPage(username,Password);

        findBy.LoginPage(homiesName,year);
    }

    @DataProvider(name = "data")
    public Object[][] dataProv(){
        return new Object[][]{
                {"GTV","1998"},
                {"Rukh","1998"}
        };
    }
}


      /*  In TestNG, you shouldn't mix @DataProvider and @Parameters in the same test method because they serve different purposes and are intended to be used independently. Here’s why:

@DataProvider: This is used to pass multiple sets of data dynamically to the test method, where each row in the Object[][] array represents a set of parameters for the test method. Each time the method is invoked, it will receive a different set of data.

@Parameters: This is used to pass static data from the XML file into your test method. The data remains constant during the execution of the test.

       */
