package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    @Parameters("firstName")
    @Test
    public void test(String name){
        System.out.println(name);
    }
    @Parameters({"Cntry","State","ZipCode"})
    @Test
    public void test2(String country, String state, String zipCode){
        System.out.println(country);
        System.out.println(state);
        System.out.println(zipCode);
    }
}
