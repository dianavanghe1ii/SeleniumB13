package SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice {

    public int sum( int num1, int num2) {
        return  num1+num2;
    }




    @Test
    public void  test1(){
        Assert.assertEquals(sum(2,6),8);
        System.out.println("Nazgul");
        Assert.assertEquals(sum(3,8),12);//fail
        System.out.println("Ion");
        Assert.assertEquals(sum(0,0),0);
        System.out.println("Mustafa");

    }
    @Test
    public void  test2() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(sum(2, 6), 8);
        System.out.println("Akyn");
        softAssert.assertEquals(sum(3, 8), 12);//fail
        System.out.println("Ayana");
        softAssert.assertEquals(sum(0, 0), 0);
        System.out.println("Tunde");
        softAssert.assertAll();

    }

}
