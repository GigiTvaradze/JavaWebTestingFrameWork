package Section16TestNG;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)
public class ListenersInterfaceInTestNG {
    @Test
    public void testMethod1() {
        System.out.println("Executing Test Method 1");
    }

    @Test
    public void testMethod2() {
        System.out.println("Executing Test Method 2");
        throw new RuntimeException("Test failure simulation");
    }
}
