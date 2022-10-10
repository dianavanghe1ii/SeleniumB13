package TestNG;

import org.testng.annotations.Test;

public class TestNGIntro {
    @Test(priority = 3)
    public void test1(){
        System.out.println("test1");
    }
    @Test(priority = 1)
    public void test2(){
        System.out.println("test2");
    }
    @Test(priority = 2, invocationCount = 5)
    public void test3(){
        System.out.println("test3");
    }
}
