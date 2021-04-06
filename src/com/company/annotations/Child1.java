package com.company.annotations;

import org.testng.annotations.*;

public class Child1 extends MainClass{
    @BeforeClass
    public void beforeClass1(){
        System.out.println("Child1- before Class");
    }
    @BeforeMethod
    public void beforeMethod1(){
        System.out.println("Child1- before Method");
    }

    @Test
    public void test11(){
        System.out.println("test11");
    }
    @Test
    public void test12(){
        System.out.println("test12");
    }
}
