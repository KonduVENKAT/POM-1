package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AnushaPage {
	
	WebDriver lDriver;
	
	public AnushaPage(WebDriver rDriver)
	{
		this.lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	// write Elements with locators @FindBy
	
	
	
}
