package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver lDriver;
	
	public HomePage(WebDriver rDriver)
	{
	this.lDriver=rDriver;
	PageFactory.initElements(rDriver, this);
		
	}

}
