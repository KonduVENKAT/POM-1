package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import POITest.ExcelTest;
//  working this code but need some implementation ;;;;; I will see next video or some other problems 
public class DDTest1 {

	public static void main(String[] args) {
		String filePath="/home/venkat/Documents/TestDataDriven.xlsx";

		
		System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
		WebDriver dri=new ChromeDriver();
		dri.get("file:///home/venkat/VENKAT%20_%20Personal/Cource%20-videos/TestPractice/venkat.html");
		
		WebElement WE_name, WE_hName , WE_phNum1, WE_phNum2,WE_email1,WE_email2 ,WE_adress;

		ExcelTest reader=new ExcelTest(filePath);
//	Name	HouseName	Number-1	Number-2	E-mail-1	E-mail-2

		WE_name=dri.findElement(By.id("userName"));
		WE_hName=dri.findElement(By.id("userHouseName"));
		WE_phNum1=dri.findElement(By.id("ph1"));
		WE_phNum2=dri.findElement(By.id("ph2"));
		WE_adress=dri.findElement(By.id("userAddress"));
		
		WE_email1=dri.findElement(By.id("eMail1"));
		WE_email2=dri.findElement(By.id("eMail2"));

		// Yes I'm getting the data  1 row and column later on i will see this 
 int  rows=reader.getLastRowCount("Sheet1");
		for(int i=1;i<=rows;i++)
		{
			
			String name=reader.getCellData(i, 0);
			System.out.println("Name       : "+name);
			
			String hName=reader.getCellData(i, 1);
			System.out.println("House Name :"+hName);
			
			String phNum1=reader.getCellData(i, 2);
			System.out.println("PhoneNumber1:"+phNum1);

			String phNum2=reader.getCellData(i, 3);
			System.out.println("PhoneNumber2:"+phNum2);

			String eMail1=reader.getCellData(i, 4);
			System.out.println("E-Mail - 1  :"+eMail1);
			
			String eMail2=reader.getCellData(i, 5);
			System.out.println("E-Mail - 2  :"+eMail2);


			String address=reader.getCellData(i, 6);
			System.out.println("Address of  :"+address);
			
			
			WE_name.clear(); WE_hName.clear(); WE_phNum1.clear(); WE_phNum2.clear();WE_email1.clear();WE_email2.clear(); WE_adress.clear();
			
			WE_name.sendKeys(name);
			try {		Thread.sleep(500); 	} catch (InterruptedException e) {	e.printStackTrace();	}
			
			WE_hName.sendKeys(hName);
			try {		Thread.sleep(500); 	} catch (InterruptedException e) {	e.printStackTrace();	}
			WE_phNum1.sendKeys(phNum1);
			try {		Thread.sleep(500); 	} catch (InterruptedException e) {	e.printStackTrace();	}
			WE_phNum2.sendKeys(phNum2);
			try {		Thread.sleep(500); 	} catch (InterruptedException e) {	e.printStackTrace();	}
			WE_email1.sendKeys(eMail1);
			try {		Thread.sleep(500); 	} catch (InterruptedException e) {	e.printStackTrace();	}
			WE_email2.sendKeys(eMail2);
			try {		Thread.sleep(500); 	} catch (InterruptedException e) {	e.printStackTrace();	}
			WE_adress.sendKeys(address);
			try {		Thread.sleep(5000); 	} catch (InterruptedException e) {	e.printStackTrace();	}
			
		}
	
	//dri.findElement(By.id("submit")).click();
	try {		Thread.sleep(5000); 	} catch (InterruptedException e) {	e.printStackTrace();	}
	
	//dri.close();
	
	}

}
