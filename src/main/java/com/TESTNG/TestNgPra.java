package com.TESTNG;
import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgPra {

	// we can execute this class only through testng.xml file only 
	
	// otherwise we will get TestNGException 
	// we are not getting the exception but Listener class will not work 
	
	// Because Listeners are there to RetryAnalyzer.interface
	
	// Directly this class unable to find that dependent  Listeners 
	
	
	//------------------------------------------------------------------
	//@BeforeSuite(name="Practiese TestNg")
	
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("---  This is beforeSuite() ---");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");
	}
	
	@BeforeClass
	public  void beforeClass()
	{
		System.out.println("before class ");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		//System.out.println("before Mehtod");
	
		System.out.println("-------------------------------------------------------");
	}
	@AfterMethod
	public void afterMethod()
	{
		//System.out.println("After Method ");
	System.out.println("\n------------------------------------------------------------");
	}
	
	
  // ----------------------------------- 1st Clause ------------------------------------
	
	
	@Test(priority=1,groups="1stClause")
	public void test001()
	{
		System.out.println("test001--Sample test sarting for testNg perpose ");
	}
	
	@Test(priority=2,groups="1stClause", dependsOnMethods="test001")
	public void test002()
	{
		System.out.println("test002--Sample test sarting for testNg perpose ");
	}
	
	@Test(priority=3,groups="1stClause",dependsOnMethods="test001")
	public void test003()
	{
		System.out.println("test003--Sample test sarting for testNg perpose ");
	}
	@Test(priority=4,groups="1stClause",dependsOnMethods="test001" )// here I removed retryAnalyzer=com.listeners.MyRetryAnalyzer.class
	public void test004()
	{
		System.out.println("test004--Sample test sarting for testNg perpose ");
		int i=9/0;
		System.out.println(i);
	}
	@Test(priority=5,groups="1stClause",dependsOnMethods="test001")
	public void test005()
	{
		System.out.println("test005--Sample test sarting for testNg perpose ");
	}
	@Test(priority=6,groups="1stClause",dependsOnMethods="test001")
	public void test006()
	{
		System.out.println("test006--Sample test sarting for testNg perpose ");
	}
	@Test(priority=7,groups="1stClause",dependsOnMethods="test001")
	public void test007()
	{
		System.out.println("test007--Sample test sarting for testNg perpose ");
	}
	@Test(priority=8,groups="1stClause",dependsOnMethods="test001")
	public void test008()
	{
		System.out.println("test008--Sample test sarting for testNg perpose ");
	}
	@Test(priority=9,groups="1stClause",dependsOnMethods="test001")
	public void test009()
	{
		System.out.println("test009--Sample test sarting for testNg perpose ");
	}
	@Test(priority=10,groups="1stClause",dependsOnMethods="test001")
	public void test010()
	{
		System.out.println("test010-Sample test sarting for testNg perpose ");
	}

	//-------------------// 2ns clause ------------------------------
	
	
	@Test(priority=11,groups="2ndClause")// High severity and high priority 
	public void test011()
	{
		System.out.println("test011--Sample test sarting for testNg perpose ");
		//int i=9/0;// Intentionally I provided Arithmetic Exception  for checking point of view 
	}
	@Test(priority=12,groups="2ndClause",dependsOnMethods="test011")
	public void test012()
	{
		System.out.println("test012--Sample test sarting for testNg perpose ");
		int i=9/0;
	}
	@Test(priority=13,groups="2ndClause",dependsOnMethods="test011")
	public void test013()
	{
		System.out.println("test013--Sample test sarting for testNg perpose ");
	}
	@Test(priority=14,groups="2ndClause",dependsOnMethods="test011")
	public void test014()
	{
		System.out.println("test014--Sample test sarting for testNg perpose ");
	}
	@Test(priority=15,groups="2ndClause",dependsOnMethods="test011")
	public void test015()
	{
		System.out.println("test015--Sample test sarting for testNg perpose ");
	}
	@Test(priority=16,groups="2ndClause",dependsOnMethods="test011")
	public void test016()
	{
		System.out.println("test016--Sample test sarting for testNg perpose ");
		int i=9/0;
	}
	@Test(priority=17,groups="2ndClause",dependsOnMethods="test011")
	public void test017()
	{
		System.out.println("test017--Sample test sarting for testNg perpose ");
	}
	@Test(priority=18,groups="2ndClause",dependsOnMethods="test011")
	public void test018()
	{
		System.out.println("test018--Sample test sarting for testNg perpose ");
	}
	@Test(priority=19,groups="2ndClause",dependsOnMethods="test011")
	public void test019()
	{
		System.out.println("test019--Sample test sarting for testNg perpose ");
	}
	@Test(priority=20,groups="2ndClause")
	public void test020()
	{
		System.out.println("test020--Sample test sarting for testNg perpose ");
	//	String names[]= {"Janaki","Venkat","Madhu","Thimmaraj","Basha"};
	//	System.out.println(names[5]);// Intentionally I provided ArrayIndexOutOfBoundsExceptions
	
	}
	
	// ----------------------- 3rd Clause -----------------------------------
	
	//@Test(priority=21,groups="3rdClause",dependsOnMethods="test020")
	//public void test021()
	{
		System.out.println("test021--Sample test sarting for testNg perpose ");
	//	String names[]= {"Janaki","Venkat","Madhu","Thimmaraj","Basha"};
	//	System.out.println(names[5]);// Intentionally I provided ArrayIndexOutOfBoundsExceptions
	}
	@Test(priority=22,groups="3rdClause",dependsOnMethods="test020")
	public void test022()
	{
		System.out.println("test022--Sample test sarting for testNg perpose ");
	
	int a[]= {0,1,2,3,4};
	//System.out.println(a[9]);
	}
	@Test(priority=23,groups="3rdClause",dependsOnMethods="test020")
	public void test023()
	{
		System.out.println("test023--Sample test sarting for testNg perpose ");
	}
	//@Test(priority=24,groups="3rdClause",dependsOnMethods="test020")
	public void test024()
	{
		System.out.println("test024--Sample test sarting for testNg perpose ");
		int i=9/0;
	}
	//@Test(priority=25,groups="3rdClause",dependsOnMethods="test020")
	public void test025()
	{
		System.out.println("test025--Sample test sarting for testNg perpose ");
	}
	@Test(priority=26,groups="3rdClause",dependsOnMethods="test020")// here I removed retryAnalyzer=com.listeners.MyRetryAnalyzer.class
	public void test026()
	{
		System.out.println("test026--Sample test sarting for testNg perpose ");
		int a[]= {0,1,2,3,4};
		System.out.println(a[9]);
		
	}
	//@Test(priority=27,groups="3rdClause",dependsOnMethods="test020")
	public void test027()
	{
		System.out.println("test027--Sample test sarting for testNg perpose ");
	}
	//@Test(priority=28,groups="3rdClause",dependsOnMethods="test020")
	public void test028()
	{
		System.out.println("test028--Sample test sarting for testNg perpose ");
	}
	//@Test(priority=29,groups="3rdClause",dependsOnMethods="test020")
	public void test029()
	{
		System.out.println("test029--Sample test sarting for testNg perpose ");
		int a[]= {0,1,2,3,4};
		System.out.println(a[9]);
		
	}
	//@Test(priority=30,groups="3rdClause",dependsOnMethods="test020")
	public void test030()
	{
		System.out.println("test030--Sample test sarting for testNg perpose ");
		int a[]= {0,1,2,3,4};
	System.out.println(a[9]);
		
	}

}
