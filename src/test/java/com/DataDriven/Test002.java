package com.DataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.utilities.ExcelUtill;

public class Test002 {

	public static void main(String[] args) {
		
		WebDriver dri;
		Actions act;
		JavascriptExecutor scriptExecutor;
		ExcelUtill excel=new ExcelUtill("/home/venkat/eclipse-workspace/POM-1/src/test/java/com/exellSheet/testExcelSheet.xlsx");
		
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
				
		dri.navigate().back();
		try {  	Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
			
		}
		dri.close();
	}

}
