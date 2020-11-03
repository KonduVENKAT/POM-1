package com.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Listeners;

//@Listeners(MC_Listener.class)
//@Listeners(MC_Listener.class)

public class Base {
	public static WebDriver driver;
	String imgFolder="./Screenshots/";
	
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("\t---@BeforeTest -----------");

		System.out.println("-----------------------------------------------------------");
	
	//	init();
	}
	@AfterTest
	public void afterTest()
	{
	System.out.println("\t---@AfterTest  ---------------");	
	System.out.println("-----------------------------------------------------------");
		//tearDown();
	}

	@BeforeClass
	public void beforeClass()
	{
		System.out.println("\t---@BeforeClass  -----------");

		System.out.println("-------------------------------------------------");
/*
		System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
	driver=new ChromeDriver();
	driver.get("file:///home/venkat/VENKAT%20_%20Personal/Cource%20-videos/TestPractice/TLogIn.html");
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	*/
	
	
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("\t---@AfterClass  -------------");
		System.out.println("-------------------------------------------------");
		System.out.println("Completed all tasks ");
		System.out.println("---------------------");
	//	driver.close();
	//driver.quit();
	}
	//--------------------------------------------------------------------------------
	
	public void takeScreen(String m_Name)
	{
		File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(image, new File(imgFolder+m_Name+".jpg"));
			System.out.println("Screenshot is taken check in \'"+imgFolder+"\'");
		} catch (IOException e) {
			System.out.println("image is not able to take check the code once ");
		
			e.printStackTrace();
		}
		
		
		
		
	}

}
