package Section17PrinciplesOfOOP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Start");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("End");
    }
}
