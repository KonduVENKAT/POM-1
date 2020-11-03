package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	//WebDriver subDriver;
	 public LoginPage lp;
//	 lp=new LoginPage(driver);// current class driver // for each method open one browser this we will use  
		

	@BeforeMethod			// For Each @Test this method is executed  before @Test methood
	public void beforeMethod()  
	{
		System.out.println("@BeforeMethod -- beforeMethod()");
		System.out.println("---------------------------------");
		
	}
	@Test(priority=0)
	public void loadLoginPage()
	{
		lp=new LoginPage(driver);// load the LoginPage class Object At first priority 
	
		logger.info("This is the first testCase Under the Base test---I'm loading the LoginPage object  ");
		// otherwise we will get NullPointerException 
	}
	
	@Test(priority=1)// If I specify priority then only 
	public void loginTestwithDet()
	{
		System.out.println("\t@Test - Method is starting ");
		System.out.println("---------------------------");
		//System.out.println("super.Driver check : "+super.driver);
		//this.subDriver=super.driver;
		//System.out.println("this.Driver check  : "+this.subDriver);
	//	lp=new LoginPage(this.subDriver);// current class driver 
	//lp=new LoginPage(super.driver);// current class driver // for each method open one browser this we will use  
									// other wise we will specify this at class level 
		lp.setUserName(prop.getProperty("uname"));
		logger.info("User name is set at the browser ");
		try {Thread.sleep(500);	} catch (InterruptedException e) {e.printStackTrace();}
		
		lp.setUserPhone(prop.getProperty("phone"));
		logger.info("Phone number is passed to the browser ");
		try {Thread.sleep(500);	} catch (InterruptedException e) {e.printStackTrace();}
		
		lp.setUserPassword(prop.getProperty("password"));
		logger.info("Password is passed to the Browser ");
		try {Thread.sleep(500);	} catch (InterruptedException e) {e.printStackTrace();}
		
	//	lp.setSubmit();
		try {Thread.sleep(500);	} catch (InterruptedException e) {e.printStackTrace();}
		Assert.assertEquals(true, false);
			
		
	}
	@Test(priority=2)
	public void radioButtons()
	{// in feature we will see @DataProvider() 
		// here we have to pass one String value for selecting the Radio Button 
			lp.radiobtnClick("female");
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			lp.radiobtnClick("male");
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			lp.radiobtnClick("other");
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
	// this is  only  for taking screen shot things to write this line of code 
			//Assert.assertEquals(false, true);// this is not right way to Assert here 
									// we have to take another package to Assert things 
	}
	
	@Test(priority=3)
	public void dropDownTest()
	{	try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
	
		lp.dropDownSelect();
		Assert.assertEquals(false, true);
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		
	}
	@Test(priority=4)
	public void multiSelectDropDownTest()
	{
		// In feature we will pass group of values for selecting multiple Select Items 
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		
	//	lp.dropDownSelect("Apple");
		lp.multipleSelect("Apple");
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		
		Assert.assertEquals(false, true);
	}
	@Test(priority=5)
	public void checkBoxSelectTest()
	{
		lp.checkBoxeClick("mca");
		try {Thread.sleep(500);	} catch (InterruptedException e) {e.printStackTrace();}
		lp.checkBoxeClick("degree");
		try {Thread.sleep(500);	} catch (InterruptedException e) {e.printStackTrace();}
		lp.checkBoxeClick("inter");
		try {Thread.sleep(500);	} catch (InterruptedException e) {e.printStackTrace();}
		lp.checkBoxeClick("school");
		try {Thread.sleep(500);	} catch (InterruptedException e) {e.printStackTrace();}
	Assert.assertEquals(false, true);	
	}
	
	//----------------------------------------------------------------------------------
	@AfterMethod			// This will be executed at each @Test after  
	public void afterMethod()
	{
		System.out.println("@AfterMethod -- afterMethod()");
		System.out.println("---------------------------------");
	}

}
