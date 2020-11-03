package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class KaranPage {
	WebDriver lDriver;
	
	public KaranPage(WebDriver rDriver)
	{
		this.lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

}
