package com.test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyCustomListener extends BaseTest implements ITestListener {
	/*
	WebDriver MCLDriver;
	public MyCustomListener()// If I want to create object of this class we need this constructor
	{						// But we don't need this constructor 
		this.MCLDriver=super.driver;// @listeners() automatically tacker of this
		PageFactory.initElements(MCLDriver, this);
		
	}
	// MCLDriver=super.driver;
	{  
	System.out.println("**********MyCustomListener******************************");
		System.out.println("Driver is Passed this loaction through  WebDriver MCLDriver=super.driver;");
		System.out.println("MyCuctomListenerDriver  : "+MCLDriver);
		System.out.println("SuperClassDriver : "+super.driver);
		System.out.println("**********MyCustomListener******************************");
	}
	// If I want to access this class methods we have to create object of this class
	// no No We can specify on @Listeners in class - level respective PageTest // Automatically we will get 
 // For Taking   Screenshots 
 // Not only in feature we will see some more things 
 //  -------------------------------------------------------------------
//*****************************************************************************
//	for this location Driver reference Not able to send Driver 
	// In this custom Listener Driver Value is become  Null Why
	// superr.driver value is also null 
	// why   	**********************************************************
	// If I'm put static WebDriver driver is super class It will work fine 
	// But non static it is not working 
	//**************************************************************************************
	// By this thing cross browser checking  Not working At that time remove this screenshot  
//*****************************************************************************	************
 * 
 */
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		//takeScreenshot(result.getClass().getName(),result.getMethod().getMethodName());
	//	WebDriver MCLDriver=super.driver;
		//{
		//	System.out.println("Driver is Passed this loaction through  WebDriver MCLDriver=super.driver;");
		//	System.out.println("MyCuctomListenerDriver  : "+MCLDriver);
		//	System.out.println("SuperClassDriver : "+super.driver);
	//	}
		
	//	System.out.println("Driver test In MyCustomListenerClass :="+driver);
		takeScreenshot(super.date,result.getMethod().getMethodName());// I'm calling that superClass method 

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("\t--- Test is skipped ---");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
