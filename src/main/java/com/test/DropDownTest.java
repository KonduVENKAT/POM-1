package com.test;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTest {
	WebDriver driver;
	Actions act;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
		driver = new ChromeDriver();
	act=new Actions(driver); // Mouse Over Actions 
		driver.get("file:///home/venkat/VENKAT%20_%20Personal/Cource%20-videos/TestPractice/TLogIn.html");

	}

	// ----------------------------- Test ------------------------------------
	//@Test
	public void dropDown() {
		// For dropDown Things

		WebElement ele = driver.findElement(By.name("cars"));
		ele.click();
		Select select = new Select(ele);
		List<WebElement> all = select.getOptions();
		System.out.println("List WebElemetns \n------------------------------------");
		System.out.println(all);
		System.out.println("----------------------------------");
		// ----------------------- How to handle this things
		// System.out.println();
		// I want to get the names Under the dropdowns
		// String dropNames[]=new String[all.size()];
		for (int i = 0; i < all.size(); i++) {
			WebElement eleDrop = all.get(i);// If I know the attribute Name I use bellow line
			// System.out.println(eleDrop.getAttribute("value"));// For getting the value of
			// that dropDownList
			// System.out.println(eleDrop.get().getText());// I want to get the Name of the
			// DropDownLists

			// If I don't know the attribute name bellow Line I will use
			System.out.println("DropDownList_Value : " + all.get(i).getText());// Here we no need to pass ("value")
			
			act.moveToElement(eleDrop).perform();// Here I Unable to perform to move mouse pointer to that element 
		
			/*
			
			// dropNames[i]=eleDrop.getAttribute("value");
			System.out.print("if you want to select this Item Enter y on console : ");
			String opt = new Scanner(System.in).next().trim();
			if (opt.contains("y") || opt.contains("Y")) {
				eleDrop.click();
				System.out.println(	"\n I Select this option : \' " + all.get(i).getText() + " \' in the browser Look at once ");
				break;
			}// if Loop
			// eleDrop.click();
			*/
			try {	Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
		}// for-Loop
		/*
		 * System.out.println("I return that dropdown List values into Array");
		 * System.out.println("--------------------------------------------------------" );
		 * for(String str:dropNames) { System.out.print(str+"\t"); } System.out.println(
		 * "\n--------------------------------------------------------");
		 */
	}// @Test

	@Test
	public void multiplesSelect() {
		
		// For handling multiple select is 
		WebElement eleFruits=driver.findElement(By.name("fruits"));
		Select multiSelect=new Select(eleFruits);
		List<WebElement> liMultiOpt=multiSelect.getOptions();
		System.out.println("Below are the values are availabel in Multiple Select opts");
		WebElement first = null,last = null;
		for(int i=0;i<liMultiOpt.size();i++)
		{
		
			WebElement eleMultiOpt=liMultiOpt.get(i);// If I want to perform some operations on that list 
			if(i==3)
			{
				first=eleMultiOpt;
				act.moveToElement(eleMultiOpt).clickAndHold();
				
			}
			if(i==5)
			{
				last=eleMultiOpt;
				act.moveToElement(eleMultiOpt).clickAndHold();
				
			}
			
			System.out.println(liMultiOpt.get(i).getText()); // this is normal List collection get the value
		
		//	act.moveToElement(eleMultiOpt).build().perform();
		
		//	act.moveToElement(eleMultiOpt).clickAndHold();
			
			try {	Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
			
		}
		try {	Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		
		act.moveToElement(first).build().perform();
		try {	Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
		
		// How could I select multiple options through Actions class
		System.out.println(" First For mouse pointerv : "+first);

		System.out.println(" Last  mouse pointer : "+last);

		try {	Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
			
	//	act.dragAndDrop(first, last); which purpose we check this line of code 
 		//act.
		
	}

	
	
	// ---------------------------------------------------------------------------
	@AfterMethod
	public void tearDown() {
		System.out.println("\t\t -- Completed tasks --  ");
		// driver.close();
	}

}
