package com.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MyWebDriverEventListener implements WebDriverEventListener {
// By using this class we see the report in our locale machine console 
// public void beforeAlertAccept(WebDriver driver) {
// public void afterAlertAccept(WebDriver driver) {
// public void afterAlertDismiss(WebDriver driver) {
// public void beforeAlertDismiss(WebDriver driver) {
// public void beforeNavigateTo(String url, WebDriver driver) {
// public void afterNavigateTo(String url, WebDriver driver) {
// public void beforeNavigateBack(WebDriver driver) {
// public void afterNavigateBack(WebDriver driver) {
// public void beforeNavigateForward(WebDriver driver) {
// public void afterNavigateForward(WebDriver driver) {
// public void beforeNavigateRefresh(WebDriver driver) {
// public void afterNavigateRefresh(WebDriver driver) {
// public void beforeFindBy(By by, WebElement element, WebDriver driver) {
// public void afterFindBy(By by, WebElement element, WebDriver driver) {
// public void beforeClickOn(WebElement element, WebDriver driver) {
// public void afterClickOn(WebElement element, WebDriver driver) {
// public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
// public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
// public void beforeScript(String script, WebDriver driver) {
// public void afterScript(String script, WebDriver driver) {
// public void beforeSwitchToWindow(String windowName, WebDriver driver) {
// public void afterSwitchToWindow(String windowName, WebDriver driver) {
// public void onException(Throwable throwable, WebDriver driver) {
// public <X> void beforeGetScreenshotAs(OutputType<X> target) {
// public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
// public void beforeGetText(WebElement element, WebDriver driver) {
// public void afterGetText(WebElement element, WebDriver driver, String text) {
// public void afterGetText(WebElement element, WebDriver driver, String text) {

	
	
	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
		// here I have to change the background color and take a screenshot os a particular web element 
		String Text=element.getText();
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
		// here I will take screenshot 
		

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub

	}

}
