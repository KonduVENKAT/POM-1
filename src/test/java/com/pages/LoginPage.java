package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	WebDriver lDriver;
	public LoginPage(WebDriver rDriver)
	{
		this.lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	//	System.out.println("Driver check in LoginPage (For Remote ): "+rDriver);
	//	System.out.println("Driver check in LoginPage(for Loacal) : "+this.lDriver);
		
	}
	// WebElements 
	@FindBy(id="userId")
	@CacheLookup
	WebElement userName;
	
	@FindBy(id="userPhone")
	@CacheLookup
	WebElement userPhone;
	

	@FindBy(id="userPass")
	@CacheLookup
	WebElement userPassword;
	
	@FindBy(id="submit")
	@CacheLookup
	WebElement submit;
	// ---------------  hyperTextLinks  ----------------------------
	@FindBy()
	@CacheLookup
	WebElement venkatPageLink;
	
	@FindBy()
	@CacheLookup
	WebElement karanPageLink;
	
	@FindBy()
	@CacheLookup
	WebElement anushaPageLink;
	
	@FindBy()
	@CacheLookup
	WebElement link4PageLink;
	
	@FindBy()
	@CacheLookup
	WebElement link5PageLink;
	
	@FindBy()
	@CacheLookup
	WebElement link6PageLink;

	
	@FindBy(name="cars")// for Cars we can perform some other options LAter 
	@CacheLookup
	WebElement dropDown;
	
	@FindBy(name="fruits")
	@CacheLookup
	WebElement multiSelect;
	
	/*		@FindBy()
	@CacheLookup
	WebElement venkatPageLink;
	
	@FindBy()
	@CacheLookup
	WebElement venkatPageLink;
	
	/*@FindBy()
	@CacheLookup
	WebElement userName;
	*/
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName1) {
		this.userName.sendKeys(userName1);
	}

	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(String userPhone1) {
		this.userPhone.sendKeys(userPhone1);
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword1) {
		this.userPassword.sendKeys(userPassword1);
	}

	/**
	 * @param submit the submit to set
	 */
	public void setSubmit() {
		this.submit.click();
	}
	// @Test in that we Know what type radio buttons names Before select 
	public void radiobtnClick(String btn_Name)// pass RadioButtonName to select from The LoginTest
	{
		// In this method we have 3 scenarios 
		/*
		 * 1- Write the WebElements 
		 * 2-isDisplayed
		 * 3-isSelected
		 * 4-isEnabled
		 * 5-If it is not select -- select it 
		 * */
		//------------------------------------------------------------------------------
		/*
		 * In feature we want to Assert this things return WebElement (driver.findElemetns) 
		 * 
		 * */
		
		// I have to store All Radio buttons WebElements address in on Array 
		// Strore in Key - value pairs also try ---- Map map=new HashMap()--
		
	//	String radioName[]= {"male","female","others"};// for names we have to specify to select 
	
		
	//	String radioAddr[]= {"id(\"male\")","id(\"female\")","id(\"other\")" }; // For WebElements Address to click/select 
		//check \" name is to set \" 
		WebElement male;
		WebElement female;
		WebElement other;
		
		
		if(btn_Name.equalsIgnoreCase("male"))
		{
				male=lDriver.findElement(By.id("male"));
			
				male.click();
		}
		else if(btn_Name.equalsIgnoreCase("female"))
		{
				female=lDriver.findElement(By.id("female"));
	 			female.click();
	 	}
	 		
		else if(btn_Name.equalsIgnoreCase("other"))
		{
				other=lDriver.findElement(By.id("other"));
	  			other.click();
	  	}
		else
		{System.out.println("In Valid Name You Enter ");}
		
	}
	public void checkBoxeClick(String chb_name)// By this method We can Select Multiple CheckBoxes 
	{
		WebElement school;
		WebElement inter;
		WebElement degree;
		WebElement MCA;
		WebElement Phd;
		if(chb_name.equalsIgnoreCase("school"))
		{
			school=lDriver.findElement(By.name("school"));
			school.click();
		}
		else if(chb_name.equalsIgnoreCase("inter"))
		{
			inter=lDriver.findElement(By.name("intermediate"));
			inter.click();
		}
		else if(chb_name.equalsIgnoreCase("degree"))
		{
			degree=lDriver.findElement(By.name("degree"));
			degree.click();
		}
		else if(chb_name.equalsIgnoreCase("MCA"))
		{
			MCA=lDriver.findElement(By.name("mca"));
			MCA.click();
		}
		else if(chb_name.equalsIgnoreCase("Phd"))
		{
			Phd=lDriver.findElement(By.name("phd"));
			Phd.click();
		}
		else
		{
		System.out.println("In_Valid Check box Name\n Nexxt time  Plaese Enter Correct CheckBox_Name");
		}
		
	}
	
	// below two features in future we implement for returnType  
	// I have to pass group of multiple select Values either array[] or ArrayList<String> li
	public void dropDownSelect() // we can select only on At a time 
	{
		// For handle auto drop down we need Select class 
		WebElement dropDown=lDriver.findElement(By.name("cars"));
		//WebElement ele = lDriver.findElement(By.name("cars"));
		Select selectDropDown=new Select(dropDown);
		System.out.println("I passe to Select(dropDown)");
		
		List<WebElement> groupDropDown=selectDropDown.getOptions();
		System.out.println("I stored that elemetns in on List object ");
		System.out.println(groupDropDown);
		System.out.println("Optiona are available in side DropDown List are ");
		System.out.println("------------------------------------------------");
		for(int i=0 ; i<groupDropDown.size();i++)
		{
			WebElement eleDrop=groupDropDown.get(i);// in feature we will perform some other actions 
			System.out.println(i+"-"+eleDrop.getText());
		}
	System.out.println("------------------------------------------------------------");
	}
	public void multipleSelect(String opts)// pass one parameter to select the particular Item
	{//Select the multiple select From at 
		// we will pass group of selected Items in 
		WebElement multiSelect=lDriver.findElement(By.name("fruits"));
		//WebElement eleFruits=lDriver.findElement(By.name("fruits"));
		Select multiDropDown=new Select(multiSelect);
		List<WebElement> groupMultiDropDown=multiDropDown.getOptions();// here we have both the 
										// WebElements and And it's information  
		System.out.println("Multiple DropDown List Values are ");

		System.out.println("------------------------------------------------------------");
		for(int i=0;i<groupMultiDropDown.size();i++)
		{
			WebElement eleOpt=groupMultiDropDown.get(i);
			if(opts.equalsIgnoreCase("school"))   //*****OLD Approach **************
			{									//In feature use MapConcept // this we will use in future 
			System.out.println(i+"-"+eleOpt.getText()+" -isSelected");
			eleOpt.click();
			}
			else if(opts.equalsIgnoreCase("inter"))
			{
				System.out.println(i+"-"+eleOpt.getText()+" -isSelected");
				eleOpt.click();
			}
			else if(opts.equalsIgnoreCase("degree"))
			{
				System.out.println(i+"-"+eleOpt.getText()+" -isSelected");
				eleOpt.click();
			}
			else if(opts.equalsIgnoreCase("mca"))
			{
				System.out.println(i+"-"+eleOpt.getText()+" -isSelected");
				eleOpt.click();
			}
			else if(opts.equalsIgnoreCase("Phd"))
			{
				System.out.println(i+"-"+eleOpt.getText()+" -isSelected");
				eleOpt.click();
			}
			else
			{
				System.out.println("No option is Passed for this method ");
			}
		
		}// ForLoop 

		System.out.println("------------------------------------------------------------");
	}
	public void linkName(String linkName)// later o  we will see return WebElement
	{
		WebElement homeLink;
		WebElement venkatLink;
		WebElement karanLink;
		WebElement anushaLink;
		WebElement link4;
		WebElement link5;
		WebElement link6;
		if(linkName.equalsIgnoreCase("homePage"))
		{
			homeLink=lDriver.findElement(By.partialLinkText("home"));
			homeLink.click();
		}
		else if(linkName.equalsIgnoreCase("venkatPage"))
		{
			venkatLink=lDriver.findElement(By.partialLinkText("venkat.html"));
			venkatLink.click();
		}
		else if(linkName.equalsIgnoreCase("karanPage"))
		{
			karanLink=lDriver.findElement(By.partialLinkText("karan Home"));
			karanLink.click();
			
		}
		else if(linkName.equalsIgnoreCase("anushaPage"))
		{
			anushaLink=lDriver.findElement(By.partialLinkText("anusha Home"));
			anushaLink.click();
		}
		else if(linkName.equalsIgnoreCase("link4"))
		{
			link4=lDriver.findElement(By.partialLinkText("link4"));
			link4.click();
		}
		else if(linkName.equalsIgnoreCase("link5"))
		{
			link5=lDriver.findElement(By.partialLinkText("link5"));
			link5.click();
		}
		else if(linkName.equalsIgnoreCase("lilnk6"))
		{
			link6=lDriver.findElement(By.partialLinkText("link6"));
			link6.click();
		}
		else
		{
			System.out.println("In_Valid linkText you passed \n Next time Entet correct LinkTest ");
		}
		
	}
}
