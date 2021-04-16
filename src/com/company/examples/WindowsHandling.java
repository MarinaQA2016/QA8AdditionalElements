package com.company.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsHandling {
    WebDriver driver;
    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        Thread.sleep(5000);
    }
    @Test
    public void windowTests() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Try it Yourself »')]")).click();
        //--- The second window was opened----
        Thread.sleep(3000);
        /*System.out.println("Text of Run button: " + driver
                .findElement(By.xpath("//button[contains(text(),'Run »')]")).getText());*/
        System.out.println("Current window: " + driver.getWindowHandle());
        String secondWindow = "";
        String firstWindow = driver.getWindowHandle();
        for(String wCode: driver.getWindowHandles()) {
            System.out.println("Window: " + wCode);
            if (!wCode.equals(firstWindow)) secondWindow = wCode;
        }
        System.out.println("Second window: " + secondWindow);
        //-- Switch to second window -----
        driver.switchTo().window(secondWindow);
        System.out.println("Text of Run button: " + driver
                .findElement(By.xpath("//button[contains(text(),'Run »')]")).getText());
        System.out.println("After switching. Current window code: " + driver.getWindowHandle());
        // --- Close current window -------
        driver.close();
        Thread.sleep(1000);
        //System.out.println("After closing. Current window code: " + driver.getWindowHandle());
        driver.switchTo().window(firstWindow);
        System.out.println("After switching. Current window code: " + driver.getWindowHandle());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
