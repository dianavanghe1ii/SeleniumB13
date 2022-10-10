package TestNG;

import org.testng.annotations.DataProvider;

public class FullNameDataProvider {
    @DataProvider(name="FullName")
    public Object[][] getData(){
        return new Object[][]{
                {"mehmet","321","1234"},
                {"malika","786","5678"},
                {"damla","312","9101"},
                {"ion","665","1121"},
                {"ahmet","656","3141"}
        };
    }
}
