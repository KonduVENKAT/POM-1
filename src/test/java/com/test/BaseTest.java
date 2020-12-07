package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.utilities.TestUtil;


@Listeners(MyCustomListener.class)
public class BaseTest {
	String screenFolderPath2="./Screenshots";// For tacking screenshots to the Particular Folder
	public static WebDriver driver;
	public static Logger logger;  // this is for Adding Logs to the project For information to store in one text file 
	String date=null;// this is for Tacking screenshots ,and extentReports >HTML File 
	
	public Properties prop;
	Actions act;
	
	//----------  Create Reference Variables  -------------
	/*
	 * public LoginPage lp; 
	 * public HomePage hp; 
	 * public VenkatPage vp;
	 * public KaranPage kp;
	 * public AnushaPage ap;
	 * 
	 * 
	 * public LoginTest lt; 
	 * public HomeTest ht; 
	 * public VenkatTest vt; 
	 * public KaranTest kt; 
	 * public AnushaTest at;
	 */
	//-----------------------------------------------------
	String propFileLoc="/home/venkat/eclipse-workspace/POM-1/Files/config.properties";
	public  BaseTest()
	{
		System.out.println("-------------------------------------------------------");
		date=getDateTime();
		System.out.println("------------ Time is fixed ("+date+")  -----------------");
		File propFile=new File(propFileLoc);
	//	System.out.println("File is loaded "+propFile);
		try {
			FileInputStream fis=new FileInputStream(propFile);
	//	System.out.println("FileInputStream is loaded ="+fis);
			prop=new Properties();
			//System.out.println("Properties Object is created ="+prop);
			prop.load(fis);
			System.out.println("Properties File is loaded ");
			System.out.println("-------------------------------------------------------");
			
		} catch (FileNotFoundException e) {
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("Configuration Fiile is not loaded properly ");
		System.out.println("------------------------------------------------------------------------------------");	
		e.printStackTrace();
		} catch (IOException e) {
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("Configuration Fiile is not loaded properly ");
			System.out.println("------------------------------------------------------------------------------------");	
			e.printStackTrace();
			}
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("@BeforeSuite--beforeSuite()");
		//System.out.println("Driver Check in @BeforeSute : "+driver);
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("@AfterSuite--afterSuite()");
//		System.out.println("Driver Check in @AfterSute : "+driver);
	}
	
	@BeforeTest
	public void beforeTest()
	{	
		System.out.println("@BeforeTest--beforeTest()");
//	System.out.println("Driver Check in @BeforeTest : "+driver);
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("@AfterTest--afterTest()");
		//System.out.println("Driver Check in @AfterTest : "+driver);
	}

	@BeforeClass
	public void beforeClass()
	{
		System.out.println("@BeforeClass--beforeClass()");
//		System.out.println("Driver Check in @BeforeClass : "+driver);
		{			
			System.out.println("I have to initialize Browser Class level ");
			System.out.println("This browser common to all @Test methods ");
		}
	
		System.out.println("\t\t --- SARTING THE BROWSER ---- ");
		System.out.println("------------------------------------------------------");
		 logger=Logger.getLogger("POM-1");  // why it is class level and here I declared before init()
		 PropertyConfigurator.configure("log4j.properties");
		
		init();
		
		driver.get(prop.getProperty("url"));
		logger.info("URL is passed to the Browser ");
		System.out.println("Url is Passed to the url--bar in the Browser  ");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		logger.info("Page load time is set to the browser ");
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		logger.info("Predefined stuff is completed ");
		System.out.println("Predeined stufff is over ");
			
	}
	@AfterClass
	public  void afterClass()
	{
		System.out.println("@AfterClass--afterClass()");
		logger.info("----  All testCasses are completed ------");
//		System.out.println("Driver Check in @AfterClass : "+driver);
		System.out.println("----------------------------------------------------");
		tearDown();
	}
	//-----------------------------------------------------------------------------------------------------------------
	public void init()  // Later we will specify (String browser) @Parammeters Passing to the bellow methods 
	{
		System.out.print("Enter Browser Name -chrome / firefox -- : ");
		String browser =new Scanner(System.in).next();
		System.out.println();	
		System.out.println();
		logger.info(browser+"Browser is going to lounching");
	//	System.out.println("Driver Check in Before - init() : "+driver);
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
			driver=new ChromeDriver();
			// Now presently working with single browser execution 
			//Here we have to add Mouse Over Actions to do mouse over Actions for that 
			act=new Actions(driver);// only once we declare 

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
			System.out.println("unable to launch the browser");
		}
	//	System.out.println("Driver Check in After init()  : "+driver);
		
		
	}
	
	
	public void tearDown()
	{
		System.out.println("Browser Will be closed with in (5 SEC )short period of time ");
		System.out.println("------------------------------------------------------------");
	//	System.out.println("Driver Check in  tearDown()  : "+driver);
		
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();	}
		System.out.println("------------------------------------------------------------");
		System.out.println("Tasks are all completed ");
		System.out.println("------------------------------------------------------------");
		driver.close();
	}
//------------------------------------------------------------------------------------------
	public  void takeScreenshot(String date, String m_Name)
	{
		String screenFolderPath4="./Screenshots";
	//	System.out.println("Why driver is null check : ="+driver);
		WebDriver mDriver=driver;
	//	System.out.println("My Local Method Driver : ="+mDriver);
		File screen=((TakesScreenshot)mDriver).getScreenshotAs(OutputType.FILE);
		try {								// Check ScreenPath 1 & 2 & 3  & 4
			FileUtils.copyFile(screen, new File(screenFolderPath4+"/"+date+"/"+m_Name+".jpg"));// will work
			System.out.println("\t ----   ScreenShot is Taken By ITestListener ------------");
			System.out.println("\t\t"+screenFolderPath4+"/"+date+"/"+m_Name);
			logger.info("--- Screenshot is taken in the folder check -----");
			System.out.println("-----------------------------------------------------------");
		} catch (IOException e) {
			System.out.println("\t ------ScreenShot Not Taken By ITestListener  -------------");
			e.printStackTrace();
		}
			
	}// this method is work for both generating extent reports and tacking screenshots  
	public String getDateTime()// remove minutes from this  
	{       					// it will create Another folder after a minute 
		String dateTime=null;// Build working on continuously minutes each minute creating folder not good practice 
		String AMPM=null;
		
		int  hour=LocalTime.now().getHour();
		int min=LocalTime.now().getMinute();
		int sec=LocalTime.now().getSecond();
		
		
		LocalDate lDate=LocalDate.now();
		DateTimeFormatter formater=DateTimeFormatter.ofPattern("d MMM uuuu");
		String date=lDate.format(formater);
		
		if(hour<12||hour==0)
		{	AMPM=" AM";}
		else
		{ AMPM=" PM";}
		
		//dateTime=date+"-Time:"+hour+min;
		dateTime=date+" -Time: "+hour+":"+min+AMPM;

		return dateTime;
	}
	
	//  -----------   For data provider  I need to create one method to get the data form the excel sheet 
	// How to create that 
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> list=TestUtil.getLoginDataFromExcel();
		
		return list.iterator();
		
	}
	
		

}
