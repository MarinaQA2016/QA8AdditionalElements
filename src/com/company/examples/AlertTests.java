package com.company.examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests {
    WebDriver driver;
    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("file:///C:/Marina/TelRan/QA%20Courses/Selenium/AlertsDemo.html");
        Thread.sleep(3000);
    }
    @Test
    public void simpleAlertTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();
        Thread.sleep(2000);

    }

    @Test
    public void confirmBoxTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        //---Press OK button
        alert.accept();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
        Thread.sleep(2000);
        alert = driver.switchTo().alert();
        //----Press Cancel button----
        alert.dismiss();
        Thread.sleep(2000);

    }
    @Test
    public void promptBoxTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        //---Enter new text----
        alert.sendKeys("Ivan Ivanov");
        Thread.sleep(2000);

        //---Press OK button
        alert.accept();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
        Thread.sleep(2000);
        alert = driver.switchTo().alert();
        //----Press Cancel button----
        alert.dismiss();
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
