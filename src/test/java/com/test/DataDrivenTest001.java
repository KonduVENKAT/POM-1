package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utilities.TestUtil;

public class DataDrivenTest001{
	
public static WebDriver dri;
	
	
	@BeforeTest
	public void setUp()
	{
	System.setProperty("webdriver.chrome.driver","/home/venkat/Softwares/Browsers/chromedriver");
	dri=new ChromeDriver();
	System.out.println("-----Browser is opend ------------");
	//dri.get("file:///home/venkat/VENKAT%20_%20Personal/Cource%20-videos/TestPractice/venkat.html");
	// the above link I will work later on 
	dri.get("file:///home/venkat/VENKAT%20_%20Personal/Cource%20-videos/TestPractice/TLogIn.html");
	System.out.println("------URL is passed ----------");
	dri.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	dri.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	// below data provider is for log in details 
	@DataProvider  // one time to Declare approach later on I will get the data form the excel sheet  
	public Iterator<Object[]> getDataForLogin() // this is for login purpose only
	{
		ArrayList<Object[]> data=TestUtil.getLoginDataFromExcel();
		return data.iterator();
		
	}
	
	// from which data I'm getting the data from the excel sheet 
//	@Test(dataProvider="getDataForLogin") // how many columns in that Excel sheet That much of parameters I Have to pass in this method 
	public void dataProvider(String userName,String phone,String password)
	{
		//Here I have to Identify the elements 
		
		
		
		//dri.findElements(By.xpath("//tagName[@id='userId']"));
		
		dri.findElement(By.id("userId")).clear();
		try {Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}
		dri.findElement(By.id("userId")).sendKeys(userName);
		try {Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}
		

		dri.findElement(By.id("userPhone")).clear();
		try {Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}
		dri.findElement(By.id("userPhone")).sendKeys(phone);
		try {Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}

		dri.findElement(By.id("userPass")).clear();
		try {Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}
		dri.findElement(By.id("userPass")).sendKeys(password);
		try {Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}

		dri.findElement(By.id("submit")).click();
		try {Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}
		try {Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}
		
		
		
	}

	// I want to create another data provider for set the details for table How to do that 
	
	
	@DataProvider
	public Iterator<Object[]> dataFeilds()
	{
		ArrayList<Object[]> dataFeilds=TestUtil.getDataFeildsFromExcelSheet();
		System.out.println("I'm getting the ArrayList<Object[]> from the TestUtil.getDataFeildsFromExcelSheet()");
		return dataFeilds.iterator();
	
	}
	
	@Test(dataProvider="dataFeilds")  // here I have to delcare method prototype for columns wise Other wise we will set data in properly or miss match data 
	public void setDataFeilds(String name,String hName,String phone1,String phone2,String address,
			String email1,String email2)
	{
		int i=1;
		
		if(i==1)
		{
		dri.findElement(By.partialLinkText("venkat")).click();
		try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();	}
		
		i=3;
		}	
		
		dri.findElement(By.id("userName")).clear();
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		dri.findElement(By.id("userName")).sendKeys(name);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		
		
		dri.findElement(By.id("userHouseName")).clear();
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		dri.findElement(By.id("userHouseName")).sendKeys(hName);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		
		
		dri.findElement(By.id("ph1")).clear();
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		dri.findElement(By.id("ph1")).sendKeys(phone1);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		
		
		dri.findElement(By.id("ph2")).clear();
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		dri.findElement(By.id("ph2")).sendKeys(phone2);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		
		
		dri.findElement(By.id("userAddress")).clear();
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		dri.findElement(By.id("userAddress")).sendKeys(address);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		
		
		dri.findElement(By.id("eMail1")).clear();
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		dri.findElement(By.id("eMail1")).sendKeys(email1);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		
		
		dri.findElement(By.id("eMail2")).clear();
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		dri.findElement(By.id("eMail2")).sendKeys(email2);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		
		
		dri.findElement(By.id("submit")).click();;
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("------  Completed All Tasks I want to close the browser ------------");
		try {Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();	}
		dri.navigate().back();
		try {Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();	}
		
		//dri.quit();// session Id is deleted so Session Id id Null so I can not perform another actions like again i'm not able to open the browser 
	//	dri.close(); // if  I'm not close the browser I data provider approach is executing perfectly 
		// with out this how could I sovle this problem
		
		
		System.out.println(" --------  Browser is closed ------------------");
	}
	
	
		

}
