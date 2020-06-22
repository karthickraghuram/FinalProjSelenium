package com.edureka.TestCalculatorJar;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import java.io.IOException;


public class CalcTest 
{    	
    public static void main(String[] args) throws IOException, InterruptedException
    {
		
	    WebDriver driver;
	    
	     String myURL = "http://35.202.27.28:9999/";//"http://35.192.9.104:9090/calculator/";
            FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--headless");
            options.setCapability("requireWindowFocus", true);
        String mygecko="/home/rsa-key-20200525/Downloads/geckodriver";

        System.setProperty("webdriver.gecko.driver",mygecko);

        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");

        driver = new FirefoxDriver(options);

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

            System.out.println("Opening " + myURL);

        driver.get(myURL);

        Thread.sleep(5000);

            String text = "This is about page";// "Addition";

        String bodyText = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println(bodyText);
//          driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys("12");
//          driver.findElement(By.xpath("/html/body/form/input[2]")).sendKeys("38");

           // driver.findElement(By.name("About Us")).click();

           driver.findElement(By.xpath("/html/body/div/header/nav/a[2]")).click();

//          driver.findElement(By.xpath("/html/body/form/input[3]")).click();
            Thread.sleep(5000);

            bodyText = driver.findElement(By.xpath("/html/body")).getText();

            System.out.println(bodyText);

            Assert.assertTrue(bodyText.contains(text), text + " not found!" );

//          Assert.assertTrue(bodyText.contains("50"), "50 not found!" );

            Thread.sleep(5000);

        driver.quit();

	}
}
