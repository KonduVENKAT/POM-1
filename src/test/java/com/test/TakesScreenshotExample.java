package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(MyCustomListener.class)
public class TakesScreenshotExample{
//	BaseTest bt;
	
	WebDriver dri;
	@BeforeMethod
	public void setUp()
	{
		
	System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");	
	dri=new ChromeDriver();
	dri.get("file:///home/venkat/VENKAT%20_%20Personal/Cource%20-videos/TestPractice/TLogIn.html");
	
	}
	@Test
	public void test100()
	{
	//Assert.assertEquals(false, true);//	
	
	File photo=((TakesScreenshot)dri).getScreenshotAs(OutputType.FILE);
	
	try {
		FileUtils.copyFile(photo, new File("./Screenshots/ontTest.jpg"));
		System.out.println("Screenshot is taken ");
	} catch (IOException e) {
		System.out.println("Screeen shot is not taken checkk the code ");
		e.printStackTrace();
	}
	
	}
	@AfterMethod
	public void tearDown()
	{
		dri.close();
	}
}
