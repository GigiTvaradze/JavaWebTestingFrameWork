package Section8FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SendingArrayToCart {

    @Test(description = "Adding Items Into Cart For Ecommerce App, Sending Array of Products to Cart")
    public void addedOneProductOnCart() {
        // Step 1: Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window

        // Step 2: Navigate to the eCommerce application
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // Step 3: Find all product names on the webpage
        List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

        // Step 4: Loop through each product to find "Cucumber"
        for (int i = 0; i < product.size(); i++) {
            String name = product.get(i).getText(); // Get the text of the product name

            // Step 5: Check if the product name contains "Cucumber"
            if (name.contains("Cucumber")) {
                // Click the "ADD TO CART" button for the found product
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break; // Exit the loop after adding the product to the cart
            }
        }

        // Step 6: Close the browser
        driver.quit(); // Terminate the WebDriver session
    }

    @Test(description = "Adding Multiple Products to Cart")
    public void addedMoreThanOneProductOnCart() {
        // Step 1: Set up the Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//WebDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Navigate to the eCommerce application
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // Step 3: Declare the array of products to be added to the cart
        String[] products = {"Cucumber", "Brocolli"};

        // Step 4: Initialize a counter to track the number of products added
        int j = 0;

        // Step 5: Find all product names on the webpage
        List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

        // Step 6: Loop through each product on the webpage
        for (int i = 0; i < product.size(); i++) {
            // Step 7: Extract and format the product name
            String[] name = product.get(i).getText().split("-");
            String formattedName = name[0].trim();

            // Step 8: Convert the array of products to a List
            List<String> items = Arrays.asList(products);

            // Step 9: Check if the formatted name is in the list of products to be added
            if (items.contains(formattedName)) {
                // Increment the counter
                j++;

                // Add the product to the cart by clicking the "ADD TO CART" button
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

                // Step 10: Break the loop once both products have been added
                if (j == 2) {
                    break;
                }
            }
        }

        // Post-condition: Close the browser
        driver.quit();
    }
}
