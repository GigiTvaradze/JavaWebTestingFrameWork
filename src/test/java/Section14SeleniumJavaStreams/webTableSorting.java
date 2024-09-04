package Section14SeleniumJavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class webTableSorting {
    @Test
    public void webTableSortingWithJavaStreams() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("page-menu")).click();
        List<WebElement> dropDownList = driver.findElements(By.cssSelector("select option"));

        Thread.sleep(1000);

        for (WebElement webElement : dropDownList) {
            String value = webElement.getAttribute("value");
            if (value.contains("20")) {
                webElement.click();
            }
        }

        //click on column
        //capture all webelemnts into list
        //capture text to all webelemts into new list
        //sort on the original list
        //compare original list vs sorted list

        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<WebElement>  tableList = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> originalList = tableList.stream().map(s -> s.getText()).collect(Collectors.toList());

        List<String> sortedlList = tableList.stream().map(s -> s.getText()).sorted().collect(Collectors.toList());

        Assert.assertTrue(originalList.equals(sortedlList));
    }


    @Test(description = "get every fruit Prices")
    public void tableSortingWithJavaStreams() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("page-menu")).click();
        List<WebElement> dropDownList = driver.findElements(By.cssSelector("select option"));

        Thread.sleep(1000);

        for (WebElement webElement : dropDownList) {
            String value = webElement.getAttribute("value");
            if (value.contains("20")) {
                webElement.click();
            }
        }

        //scan the name column with getText -> Rice -> print the price of Rice
        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<WebElement>  tableList = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> originalList = tableList.stream().map(s -> s.getText()).collect(Collectors.toList());

        List<String> sortedlList = tableList.stream().map(s -> s.getText()).sorted().collect(Collectors.toList());

        Assert.assertTrue(originalList.equals(sortedlList));

        List <String> price = tableList.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
        price.forEach(a-> System.out.println(a));
    }

    private static String getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[2]")).getText();
        return priceValue;
    }


    @Test()
    public void LiveDemo (){
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        // click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // capture all webelements into list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        // capture text of all webelements into new(original) list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

        // sort on the original list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        // compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));

        List<String> price;
        // scan the name column with getText ->Beans->print the price of the Rice
        do
        {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

            price = rows.stream().filter(s -> s.getText().contains("Rice"))

                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));

            if(price.size()<1)
            {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while(price.size()<1);
    }

    @Test()
    public void filterFunctional () {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));

        //1 results
        List<WebElement> filteredList= veggies
                .stream()
                .filter(veggie->veggie
                        .getText()
                        .contains("Rice"))
                .collect(Collectors.toList());

        //1 result
        Assert.assertEquals(veggies.size(), filteredList.size());

    }
}
