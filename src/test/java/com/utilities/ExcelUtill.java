package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/// working fine according to my expectations 
public class ExcelUtill {
	FileInputStream fis=null;
	FileOutputStream fos=null;
	
	
	XSSFWorkbook wb; // this will create only one time to load the excel sheet 
	XSSFSheet sheet;  //this will change at the time of whenever we change the sheet name time of the particular workbook 
	
	XSSFRow row;   // this will change when we want to get the row data and set the row data time
	XSSFCell cell; // this will change for each cell creation and geeting the cell data 
	
	
	//***********************************************************************************************
	
	
	String filePath=null;
	public ExcelUtill(String fPath)
	{
		 filePath=fPath;
		
		File file=new File( filePath);
		try {
			 fis=new FileInputStream(file);
			System.out.println("Excel file is loaded for geting the data ");
			 wb=new XSSFWorkbook(fis);// for workbook loaded purpose 
			
		} catch (FileNotFoundException e) {
			System.out.println("File is not loaded for this path check :"+ filePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Workbook is not loaded check the code");
			e.printStackTrace();
		}
		
		
		
		
	System.out.println("Excel file is loaded ");	
	}
	
	// How to implement below methods are required for me there is no need set row Data things for me . 
	public int getLastRowNumber(String sheetName) //I want to get the Last row number of that sheet 
	{
		int getLastRow=0;
		
		
		getLastRow= wb.getSheet(sheetName).getLastRowNum();
		//getLastRow= getLastRowNumber(sheetName); // how to get that value
		System.out.println("Last Row Number is ="+getLastRow);
		return getLastRow;
	}
	public int getLastColoumnNumber(int rowNum)// I want to get the last column Number of the particular row 
	{
		int getLastColoumn=0;
		
		
		
		
		return getLastColoumn;
	}
	public void addSheet()
	{
		
	}
	public void removeSheet()
	{
		
	}
	
	
	public String getCellValue(String sheetName,String columnName, int rowNum) // I want get the cell vale of the particular cell Value
	{
		
		String c_Data=null;
		
		sheet=wb.getSheet(sheetName);
		//System.out.println(sheetName+" Sheet is getting the current window I set");
		
		// I want to get the particular column data how to get that data 
		
		
		//int cellNum=row.getFirstCellNum(); // I'm not getting that cell data of a particular column
		// cell=row.getCell(cellnum); // How to get the data of a particular column name  
		
		// for that I'm using for loop for columns names 
		// I need last column number of a row 
		 row=sheet.getRow(0);  // for get the  columns data 
		int lastColNum=row.getLastCellNum();
		//int colNum=0;// declaration
		
		// Below for loop is for getting the column number of the particular Name 
		for(int i=0;i<lastColNum;i++)  /// Yes I'm getting the columns names then what i Have to do
		{
			String colName=row.getCell(i).getStringCellValue();
			//System.out.println("column Name of row Number[ "+0+" ] cell Number [ "+i+" ]  == "+colName);
			//try {Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();	}
			
			//if(columnName.trim()==colName.trim())// this is not right way to compare two String 
			
		if(columnName.trim().equalsIgnoreCase(colName.trim())) // wroking fine as per my expectations
		{
			//	colNum=i+1; // for get the cell Number of the column Name 
				//Here I have to get  the data from the required row number 
				
				
				 row=sheet.getRow(rowNum-1);  /// rouNum-1 is exact row number in excel sheet 
				String cellData=row.getCell(i).getStringCellValue();
				c_Data=cellData;
				System.out.println("sheetName [ "+sheetName+" ] RowNumber [ "+rowNum+" ] ColumnName [ "+columnName+" ] cellData = "+c_Data);
				
				break; // no need to continue this loop for after finding the value of the cell of a particular row number 
				
			
		} // if - close
		} // for loop 
		
		
		// row=sheet.getRow(rowNum);
		//System.out.println("Row is get from the sheet name :"+sheetName);
		
		return c_Data;
	}
	
	// Bellow method working fine as per my expectations 
	public void getRowValues(String sheetName,int rowNum)// Here I want get the row Data from the particular sheet name 
	{
		
		 sheet=wb.getSheet(sheetName);// for get the particular sheet name from that workbook
		System.out.println("Sheet is loaded from that workbook ");
		// Here I don't need Last Row Number and column Number 
		
		//For get the particular row data things 
		int  lastRowNumber=sheet.getLastRowNum();
		System.out.println("last Row Number is :"+lastRowNumber);
		
				
		 row=sheet.getRow(rowNum);// check her rowNum-1 or rowNum+1 for this
		//After that what I have to do  for getting the each cell data from that row in the sheet 

		
		// for this I need last Column number for 
		int lastColNumber= row.getLastCellNum();
		System.out.println("last column Number is : "+lastColNumber);
		
		for(int i=0;i<lastColNumber;i++)
		{
			int cellnum=i; // check i=0 or i=-1;
			
		 cell=row.getCell(cellnum);
		String cellData=cell.getStringCellValue();
		System.out.println(" I get the cell data from the row [ "+rowNum+" ] = cell [ "+cellnum+" ] data= "+cellData);
		if(i==3)
			{
				System.out.println("\n------------------------------------------------_______-----------------------------");
			}// if close
			
		}// for loop 
	}
	
	public void setCellData(String cData,XSSFRow rrow,int cellNum)// I will implement  later on bellow this methods. 
	{
		
		
	}// setCellDatar   close 
	public void setRowData(String[] rData,XSSFRow rrrow,int rowNum)
	{
		
	}
	
	// ********************************************************************************************
	public static void main(String args[])
		{
			
			String excelFile="/home/venkat/eclipse-workspace/POM-1/src/test/java/com/exellSheet/testExcelSheet.xlsx";
			ExcelUtill ex=new ExcelUtill(excelFile);
		//For repeated task I need last Row number in particular sheet what I will do 
			int lastRowNum=ex.getLastRowNumber("login");
			//System.out.println("last row number of the partiular sheet Name details : "+lastRowNum);
		/*
		 * for(int i=0;i<=lastRowNum;i++) { ex.getRowValues("details",i); }
		 * 
		 */
			
			//ex.getCellValue("details","",  0);// this is one approach to get the data from the cell in excel sheet Not required in real time 
			// we need here get the data from entire row in String[] for mat or ArrayList format ;
			
			
			System.out.println("UserNames \n-----------------------------------------");
			for(int rowNum=2;rowNum<=lastRowNum;rowNum++)
			{
				
				
				String userName=ex.getCellValue("login", "userName", rowNum);
				
			}

			System.out.println("\nPhoneNumbers \n-----------------------------------------");
			for(int rowNum=2;rowNum<=lastRowNum;rowNum++)
			{
				String phone=ex.getCellValue("login", "phone", rowNum);
			}
			

			System.out.println("\npasswords \n-----------------------------------------");
			for(int rowNum=2;rowNum<=lastRowNum;rowNum++)
			{
				String password=ex.getCellValue("login","password", rowNum);
			}
			
			//String cellData=ex.getCellValue("login","phone", 4);  // I'm getting null why 
		//	System.out.println("\n celll data of row number [ 2 ] columns name [ E-mail ]=="+cellData);
			
		}  ///  Main  method level   close
		

} /// class level close 
