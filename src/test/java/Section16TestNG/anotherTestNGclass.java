package Section16TestNG;

import org.testng.annotations.Test;

public class anotherTestNGclass {

    @Test
    public void demo(){
        findBy findBy = new findBy();
        findBy.LoginPage("","");
    }
}
