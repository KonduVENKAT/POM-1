package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest010 {
	public static WebDriver driver; // check I remove static 
	public Properties prop;
	// Properties file loaction 
	String propFileLoc="/home/venkat/eclipse-workspace/POM-1/Files/config.properties";
	String propFileLoc1="./Files/config.properties";
	
	String propFL="./Files/config.properties";
	public BaseTest010()
	{
		FileInputStream fis=null;
		File propFile1=new File(propFL);
		try {
			fis=new FileInputStream(propFile1);
			System.out.println("Properties file is loaded ");
			prop=new Properties();
			prop.load(fis);
			System.out.println("Proprties file is again Loaded for **** new Proprties() ****");
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("properties file not loaded properly ");
			e.printStackTrace();
		}	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("\t--- @BeforeSuite  --------");
		System.out.println("-------------------------------------------------------------------");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("\t---@AfterSuite  ----------");

		System.out.println("-------------------------------------------------------------------");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("\t---@BeforeTest -----------");
		System.out.println("Driver Check in @BeforeTest : "+driver);

		System.out.println("-----------------------------------------------------------");
	
		//init();
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

		System.out.println("Driver Check in @BeforeClass : "+driver);
	
		System.out.println("-------------------------------------------------");
		init();
		driver.get(prop.getProperty("url"));
		System.out.println("Url is Passed to the url--bar in the Browser  ");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		System.out.println("Predeined stufff is over ");
		System.out.println("----------------- After init() -----------------------");
		System.out.println("Driver Check in @BeforeClass : "+driver);

	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("\t---@AfterClass  -------------");
		System.out.println("-------------------------------------------------");
		tearDown();
	}
	
	//----------------------------------------------------------------------
	public void init()
	{
		System.out.print("Enter Browser Name -chrome / firefox -- : ");
		String browser =new Scanner(System.in).next();
		System.out.println();	
		System.out.println();

		System.out.println("Driver Check in Before - init() : "+driver);
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
			driver=new ChromeDriver();

			System.out.println("\t\t ---- LAUNCHING THE \' "+browser+" \' BROWSSER -----");
			System.out.println("--------------------------------------------------------");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/home/venkat/Softwares/Browsers/geckodriver");
														///home/venkat/Softwares/Browsers/geckodriver");
			driver=new FirefoxDriver();
			System.out.println("\t\t ---- LAUNCHING THE \' "+browser+" \' BROWSSER -----");
			System.out.println("--------------------------------------------------------");
		
		}
		else 
		{
			System.out.println("Browser name \' "+browser+" \'is not correct check once ");
			System.out.println("unable to launch that browser");
		}
		System.out.println("Driver Check in After init()  : "+driver);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	public void tearDown()
	{
		System.out.println("Browser Will be closed with in (5 SEC )short period of time ");
		System.out.println("------------------------------------------------------------");
		System.out.println("Driver Check in  tearDown()  : "+driver);
		
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();	}
		System.out.println("------------------------------------------------------------");
	System.out.println("Tasks are all completed ");
	System.out.println("------------------------------------------------------------");
		driver.close();

		
	}
	public void screenshot(String m_Name)// this method called By MyCustomListener class Calling 
	{									// By tacking automatically failedTestCasses 
										// onTestFailure(ITestResullt result)
		System.out.println("***********************************************************");
		System.out.println("driver At Screenshot(method_Name) Called By ITestListener : "+driver);
		System.out.println("***********************************************************");
		File photo=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(photo, new File("./Screenshots/"+m_Name+".jpg"));
			System.out.println("Screenshot is taken ");
		} catch (IOException e) {
			System.out.println("Screeen shot is not taken checkk the code ");
			e.printStackTrace();
		}
		
		///home/venkat/eclipse-workspace/POM-1/Screenshots
		//	String screenFolderPath3="/home/venkat/eclipse-workspace/POM-1/Screenshots";
		/*
		 * String screenFolderPath4="./Screenshots";
		 * System.out.println("Why driver is null check : ="+driver); WebDriver
		 * mDriver=driver;
		 */
		System.out.println("My Local Method Driver : ="+driver);
		/*
		 * File screen=((TakesScreenshot)mDriver).getScreenshotAs(OutputType.FILE);
		 * 
		 * // try { // Check ScreenPath 1 & 2 & 3 & 4 FileUtils.copyFile(screen, new
		 * File(screenFolderPath4+"/"+m_Name+".jpg"));// will work System.out.
		 * println("\t ----   ScreenShot is Taken By ITestListener ------------"); }
		 * catch (IOException e) { System.out.
		 * println("\t ------ScreenShot Not Taken By ITestListener  -------------");
		 * e.printStackTrace(); }
		 * 
		 * 
		 */		
	}
	
}
