import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class assignmentN7 {
    @Test
    public void assignment() {

        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaclickacademy.com/practice.php");

        //print number of rows presented in table
        int sum = 0;
        List<WebElement> listOfCourses = driver.findElements(By.xpath("//table[@name='courses'] //tr"));
        for (int i = 0; i < listOfCourses.size(); i++) {
            sum++;
        }

        //print number of column presented in table
        int columnSum = 0;
        List<WebElement> numbOfColumn = driver.findElements(By.xpath("//table[@name='courses'] //tr //th"));
        for (int i = 0; i < numbOfColumn.size(); i++) {
            columnSum++;
        }

        //print second row content
        List<WebElement> secondRowContent = driver.findElements(By.xpath("//table[@name='courses'] //tr //td [2]"));
        for (int i = 0; i < secondRowContent.size(); i++) {
            String rowContent = listOfCourses.get(2).getText();
            System.out.println(rowContent);
        }
    }

    @Test
    public void assignmentAnswer() {

        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaclickacademy.com/practice.php");
        WebElement table=driver.findElement(By.id("product"));



        System.out.println(table.findElements(By.tagName("tr")).size());



        System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());



        List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));



        System.out.println(secondrow.get(0).getText());



        System.out.println(secondrow.get(1).getText());



        System.out.println(secondrow.get(2).getText());

    }
}
