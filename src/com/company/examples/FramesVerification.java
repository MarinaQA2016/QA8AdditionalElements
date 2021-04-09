package com.company.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesVerification {
    WebDriver driver;
    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        Thread.sleep(2000);
    }
    @Test
    public void framesTest() throws InterruptedException {
        //--- Inside default content----
        System.out.println("Run button name: " + driver.findElement(By.xpath("//button[contains(text(),'Run »')]")).getText());
        Thread.sleep(1000);
        System.out.println("HTML IFrames: " + driver.findElement(By.xpath("//h2")).getText());
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        //--- Inside first frame ------
        System.out.println("------------Inside first frame-----------");
        Thread.sleep(1000);
        System.out.println("HTML IFrames- first frame: " + driver.findElement(By.xpath("//h2")).getText());
        //System.out.println("Second frame: " + driver.findElement(By.xpath("//h1")).getText());
        //System.out.println("Run button name: " + driver.findElement(By.xpath("//button[contains(text(),'Run »')]")).getText());
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title ='Iframe Example']")));
        System.out.println("------------Inside second frame-----------");
        Thread.sleep(1000);
        System.out.println("Second frame: " + driver.findElement(By.xpath("//h1")).getText());
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        System.out.println("------------Inside default content -----------");
        Thread.sleep(1000);
        System.out.println("Run button name: " + driver.findElement(By.xpath("//button[contains(text(),'Run »')]")).getText());
        System.out.println("HTML IFrames- first frame: " + driver.findElement(By.xpath("//h2")).getText());



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
