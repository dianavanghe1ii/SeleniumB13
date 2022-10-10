package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
    //it runs the same test with a different SET of DATA
//    @DataProvider(name="FullName")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"mehmet","321","1234"},
//                {"malika","786","5678"},
//                {"damla","312","9101"},
//                {"ion","665","1121"},
//                {"ahmet","656","3141"}
//        };
//    }

    @Test(dataProvider ="FullName", dataProviderClass = FullNameDataProvider.class)
    public void test( String username, String password, String creditCard){
        System.out.println(username+password+creditCard);
    }

}
