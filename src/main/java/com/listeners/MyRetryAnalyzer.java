package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{

	int count=0;
	int countRetryLimit=3;// Here we specify number of chances are given to failed test casess
// this  Class is one bad approach 
	// we have to specify at @Test () Annotation inside 
	//retryAnalyzer=com.listeners.MyRetryAnalyzer.class
	//The above we have to use 
	
	@Override
	public boolean retry(ITestResult result) {
	
		if(count<countRetryLimit)
		{
			count++;
			return true;
		}
		
		System.out.println("-- RetryAnalyzer is executed ----");
		return false;
	}

}
