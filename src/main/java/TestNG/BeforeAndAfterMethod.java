package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterMethod {
    @BeforeMethod
    public void establish(){//OR setup()
        System.out.println("I am BeforeMethod Annotation");//3
    }
    @Test
    public void test1(){
        System.out.println("I am test 1");//1
    }
    @Test
    public void test2(){
        System.out.println("i am test 2");//1
    }
    @Test
    public void test3(){
        System.out.println("i am test 2");//1
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("I am AfterMethod");//3
    }

}
