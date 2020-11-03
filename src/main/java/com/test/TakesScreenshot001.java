package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MC_Listener.class)
public class TakesScreenshot001 extends Base {
	
	//LoginPage lp;
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("SetUp Method");
		System.out.println("\t --- @BeforeMethod --- \n--------------------------------");
		System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
		driver=new ChromeDriver();
		driver.get("file:///home/venkat/VENKAT%20_%20Personal/Cource%20-videos/TestPractice/TLogIn.html");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}
	@Test
	public void test001()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test002()
	{
		Assert.assertEquals(false, true);
	}
	@Test
	public void test003()
	{
		Assert.assertEquals(false, true);
	}
	@Test
	public void test004()
	{
		Assert.assertEquals(false, true);
	}
	
	
	@AfterMethod
	public void teerDown()
	{

		System.out.println("\t-- @AfterMethod---\n--------------------------------");
	driver.close();
	}

}
