package com.DataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.ExcelUtill;

public class Test001 {
	
	
	public static WebDriver dri;
	Actions act;
	JavascriptExecutor scriptExecutor;
	ExcelUtill excel=new ExcelUtill("/home/venkat/eclipse-workspace/POM-1/src/test/java/com/exellSheet/testExcelSheet.xlsx");
	
	
	//@BeforeClass
	public void setUp()
	{
		/*
		System.setProperty("webdriver.chrome.driver","/home/venkat/Softwares/Browsers/chromedriver");
		dri=new ChromeDriver();
		act=new Actions(dri);
		scriptExecutor=(JavascriptExecutor)dri;
		dri.get("file:///home/venkat/VENKAT%20_%20Personal/Cource%20-videos/TestPractice/TLogIn.html");
		dri.manage().deleteAllCookies();
		dri.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dri.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		dri.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		System.out.println("Predefiend work is comepleted ");
		System.out.println("----------- URL is loaded in the Browser ------------------");

	*/
	}
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.setProperty("webdriver.chrome.driver","/home/venkat/Softwares/Browsers/chromedriver");
		dri=new ChromeDriver();
		act=new Actions(dri);
		scriptExecutor=(JavascriptExecutor)dri;
		dri.get("file:///home/venkat/VENKAT%20_%20Personal/Cource%20-videos/TestPractice/TLogIn.html");
		dri.manage().deleteAllCookies();
		dri.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dri.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		dri.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		System.out.println("Predefiend work is comepleted ");
		System.out.println("----------- URL is loaded in the Browser ------------------");

		
	}
	
	
//	@Test()// how to pass the values from this page How to do this 
	public void dataDrivenTest001()
	{
		WebElement userName=dri.findElement(By.id("userId"));
		WebElement userPhone=dri.findElement(By.id("userPhone"));
		WebElement password=dri.findElement(By.id("userPass"));
		WebElement  submit=dri.findElement(By.id("submit"));
		
		userName.clear();
		try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		userName.sendKeys("konduvenkatarao9999");
		try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		userPhone.clear();
		try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		userPhone.sendKeys("9885861920");
		try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		
		password.clear();
		try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		password.sendKeys("7865347563478956348976");
		try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		
		submit.click();
		try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
			
		
		
		
		
	}
	
	@Test// how to implement this 
	public void TestDrivenDevlopment()
	{
//		WebElement userName=dri.findElement(By.id("userId")); // I'm getting staleElement Exception  
//															// How could I over come this 
//		WebElement userPhone=dri.findElement(By.id("userPhone"));
//		
//		WebElement password=dri.findElement(By.id("userPass"));
		
//		WebElement  submit=dri.findElement(By.id("submit"));
		

		
		int lastRowNum=excel.getLastRowNumber("login");
	
		for(int rowNum=2;rowNum<=lastRowNum;rowNum++)
		{

				
			dri.findElement(By.id("userId")).clear();
			try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
	String user=excel.getCellValue("login", "userName", rowNum);
			
			dri.findElement(By.id("userId")).sendKeys(user);
			try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
			dri.findElement(By.id("userPhone")).clear();
			try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
	String phoneNumber=excel.getCellValue("login", "phone", rowNum);
			
			dri.findElement(By.id("userPhone")).sendKeys(phoneNumber);
			try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
			
			dri.findElement(By.id("userPass")).clear();
			try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
	String pass=excel.getCellValue("login", "password", rowNum);
			
			dri.findElement(By.id("userPass")).sendKeys(pass);
			try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
			
			dri.findElement(By.id("submit")).click();
			try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
				
		
			
			
		}
		
		
			
		
	}
	
	@AfterMethod
	public void afterMethod()
	{/*
		 * try { Thread.sleep(500);} catch (InterruptedException e)
		 * {e.printStackTrace();}
		 * 
		 * dri.navigate().back(); try { Thread.sleep(1000);} catch (InterruptedException
		 * e) {e.printStackTrace();}
		 */	

		System.out.println("-----Completed All taks I want to close the browser  ------------");
		
		
		try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		//dri.quit();// entaire session is closed
		dri.close();
		System.out.println("Borwser is closed ");
	
	}
	
	//@AfterClass
	public void tearDown()
	{
		System.out.println("-----Completed All taks I want to close the browser  ------------");
	
	
	try {  	Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
	dri.close();
	
	}
	
	

}
