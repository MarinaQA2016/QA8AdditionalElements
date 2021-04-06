package com.company.annotations;

import org.testng.annotations.*;


public class MainClass {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("MainClass - Before Suit");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("MainClass - Before Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("MainClass - Before Method");
    }
}
