package com.utilities;

import java.util.ArrayList;

public class TestUtil {
// In this class I will get the create object of the ExcelUtil class and get the data from the excel sheet 
// How to do that 
	static ExcelUtill excel;
										// method signature and method prototype 
	public static ArrayList<Object[]> getLoginDataFromExcel()
	{

		System.out.println("**********************************************");
		System.out.println("Present I'm in getLoginDataFromExcelSheet()");
		System.out.println("**********************************************");
		ArrayList<Object[]> arrayList=new ArrayList<Object[]>(); // I need to return this object inside 
		// what is called data validation not that what it is called return type is like that  
		// It's called  Generic  --> It  will accepts only one dataType values in that Allry list  
		//arrayList.add("dhfuiouad"); this type is not accepted because that ArrayList stores only Object data type values only 
					// Because it That ArrayList declare it's return type only Object[] type 
		// arrayList.add(Object[] e) // will accepts 
		
		try {
			excel=new ExcelUtill("/home/venkat/eclipse-workspace/POM-1/src/test/java/com/exellSheet/testExcelSheet.xlsx");//I have to pass excel file location ;;
			System.out.println("Excel file is loaded for this method");
		}catch(Exception e)
		{
			System.out.println("Excel file is not loaded check the method ");
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=excel.getLastRowNumber("login");rowNum++)// here we have to specify 
		{				// rowNum<=Number of Rows are available in that sheet  		
			// that many number of times execute that data provider method at @Test() method  
			String userName=excel.getCellValue("login", "userName", rowNum);
			
			String phone=excel.getCellValue("login", "phone", rowNum);
			
			String password=excel.getCellValue("login","password", rowNum);
			
			Object[] obj= {userName,phone,password};

			arrayList.add(obj);
					
		}
			
		return arrayList;
		
	}
	
	public static ArrayList<Object[]> getDataFeildsFromExcelSheet()
	{

		System.out.println("**********************************************");
		System.out.println("Present I'm in getDataFeildsFromExcelSheet()");
		System.out.println("**********************************************");
		ArrayList<Object[]> list=new ArrayList<Object[]>();
		
		
		// for this I have to load the excel file first
		
		try {
			// I have to create of the Objcet of the Excel file utility first 
			
			excel=new ExcelUtill("/home/venkat/eclipse-workspace/POM-1/src/test/java/com/exellSheet/testExcelSheet.xlsx");
			System.out.println("Excel file is loaded for DataDriven approach ");
		}catch(Exception e)
		{	System.out.println("Excel file is not loaded from the the path");
			e.printStackTrace();}
		
		
		// Then I have to create create the for loop for getting the data form the excel sheet 
		String sheetName="UserDetails";
		
		for(int rowNum=2;rowNum<=excel.getLastRowNumber("UserDetails");rowNum++)
		{	 //  here actually number of rows are 10 but  I'm getting 9 rows only what is the problem
			System.out.println("For loop is executin ----------------------");
			
			String name=excel.getCellValue(sheetName, "Name", rowNum);
			String hName=excel.getCellValue(sheetName, "HouseName", rowNum);
			String phone1=excel.getCellValue(sheetName, "number1", rowNum);
			String phone2=excel.getCellValue(sheetName, "number2", rowNum);
			String address=excel.getCellValue(sheetName, "address", rowNum);
			String email1=excel.getCellValue(sheetName, "E-Mail1", rowNum);
			String email2=excel.getCellValue(sheetName, "E-mail2", rowNum);
			
		Object[] obj= {name,hName,phone1,phone2,address,email1,email2};
		list.add(obj);
		System.out.println("Object is collected and stored in the list object ");
		}

		return list;
	}
	
}
