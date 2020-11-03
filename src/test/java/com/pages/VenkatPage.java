package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VenkatPage {
	
	WebDriver lDriver;
	
	public VenkatPage(WebDriver rDriver)
	{
		this.lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	//Write Elements Locators @FindBy
	//-----------------------------------------
	
}
