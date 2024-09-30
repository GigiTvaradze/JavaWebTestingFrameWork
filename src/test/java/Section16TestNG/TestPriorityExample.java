package Section16TestNG;

import org.testng.annotations.Test;

public class TestPriorityExample {

    @Test(priority = 1)
    public void loginTest() {
        System.out.println("Login test executed");
    }

    @Test(priority = 2)
    public void searchTest() {
        System.out.println("Search test executed");
    }

    @Test(priority = 3)
    public void addToCartTest() {
        System.out.println("Add to Cart test executed");
    }

    @Test(priority = 4)
    public void checkoutTest() {
        System.out.println("Checkout test executed");
    }
}
