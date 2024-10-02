package Section16TestNG;

import org.testng.annotations.DataProvider;

public class dataProvider {

    //Two Dimensional
    @DataProvider(name = "asdki")
    public Object[][] asd(){
        return new Object[][]{
                {},
                {}
        };
    }

    //One Dimensional
    @DataProvider(name = "a12dki")
    public Object[] fdsf(){
        return new Object[]{"",""};
    }
}
