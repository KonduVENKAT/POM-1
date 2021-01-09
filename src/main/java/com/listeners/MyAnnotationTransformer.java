package com.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyAnnotationTransformer implements IAnnotationTransformer {
	// this class automatically calls internally MyRetryAnalyzer 
	// As part of re executing the failed test cases  number of times repeating depending on that class level declaration please check  
	// there is no need to specify @Test(retryAnalyzer=com.listeners.Class_Name.clss)
	// But we have to mention this Listener in at testNG.xml file to call this Listener class
	// whenever the test case is failed automatically listener will triggered and  calleed that MyRetryAnalyzer.class inside that retry() will 			// called 
	
	public void transform(ITestAnnotation annotation,Class testClass,Constructor testConstructor,Method testMethod)
	{
		
		//annotation.setRetryAnalyzer(MyRetryAnalyzer.class);
		annotation.setRetryAnalyzer(MyRetryAnalyzer.class);
		
	}

}
