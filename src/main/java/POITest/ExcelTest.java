package POITest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
	
	
	//String exFilePath="/home/venkat/eclipse-workspace/POM-1/Files/testExcelSheet.xlsx"; // this one is working 
	String exFilePath=null;
	String ExPath="./Files/POM2.xlsx"; // check which one is work 
	Scanner s=new Scanner(System.in);
	
	public FileInputStream fis;
	public FileOutputStream fos;
	
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	
	public XSSFRow row;
	public XSSFCell cell;
	
	public ExcelTest(String exPath) // constructor things load excel file and some operations 
	{
		exFilePath=exPath;
		
		try {
			fis=new FileInputStream(exFilePath);
			System.out.println("Excel File is loaded in FIS : "+fis);
			
			wb=new XSSFWorkbook(fis);
			
			sheet=wb.getSheet("sheet1"); //sheet name I have to write pass or write 
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("FIS file is not loaded properly check once ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Workbook is not loaded properly check once ");
			e.printStackTrace();
		}
		
	}
	
	public int getLastRowCount(String sheetName) 
	{
		int lastRowNum=sheet.getLastRowNum();
		System.out.println("Last Row Number : : "+sheet.getLastRowNum());
		
		return sheet.getLastRowNum();
	}
	public int getLastColCount(int rouNum)// for each row columns size may be different check this latter
	{
		row=sheet.getRow(2);
		System.out.println("Last Colomn Count : : "+row.getLastCellNum());
		return row.getLastCellNum();
	}
	
	public String getCellData(int rowNum,int colNum) // this is called each Time need get The cell data o
	{						// What about Getting the Row Data and Rows Data is is good this 
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
			
		DataFormatter df=new DataFormatter();
		String cellData=df.formatCellValue(cell);
		
		System.out.println("cell Data :: "+cellData);
		//System.out.println(cell.getCell);
		return cellData;
	}
	public void setCellData(String data,int rowNum,int colNum)
	{
		
		int lastRowNum=sheet.getLastRowNum();
		System.out.println("lastRow Number in sheet : "+lastRowNum);
		if(lastRowNum==-1)   // check this row number is in at position at -1 may be we have to write columns values 
		{
			lastRowNum=lastRowNum+1;
			System.out.println("lastRow Number in sheet : "+lastRowNum);
			
			row=sheet.createRow(lastRowNum);
			System.out.println("Row is crewated at Position 0 check  ");
			getLastRowCount("Sheet1");	
		}
				
		row=sheet.getRow(rowNum); // if RowNum is Facing Null Pointer exception what I will do 
		
		System.out.println("Row value : "+row);
		
		if(row==null)
		{
			
			row=sheet.createRow(rowNum);
			System.out.println("Row is created : "+row);
		}
			
		/*
		int lastCellNum=row.getLastCellNum();
		if(lastCellNum==-1)
		{
			lastCellNum=lastCellNum+2;
			cell=row.createCell(lastCellNum);
		}
		*/
		cell=row.getCell(colNum);
		//System.out.println("Cell value : "+cell);
		if(cell==null)
		{
			cell=row.createCell(colNum);
			System.out.println("Coloumn is created for writing the Data :: "+cell);
		}
		
		cell.setCellValue(data);
		
		System.out.println("Value is inserted check it is wotking or not "); // here we have to use FileOutputStream 
		// For writing the data 
		try {
			fos=new FileOutputStream(exFilePath);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			System.out.println("For FileOutputStrem is not loaded properly check it once ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to Write the Data in Cell ");
			e.printStackTrace();
		}
		
		getCellData(rowNum,colNum);
	}
	public void setRowData()
	{
		
		
		
	}
	public void RowsDataGet(String sheetName,int startWith)
	{
		int startRowNum=startWith;
		// Actually I need Last Number of row Number 
		
		// ---- For Rows things -----
		int lastRowSize=getLastRowCount("Sheet1");
		//System.out.println("Last row Number in current woring sheet is :: "+lastRowSize);
		
		//   ----  For columns things -- --  
		int lastColSize=getLastColCount(startRowNum);
		//System.out.println("Last Column Number in the current working sheet and in current working Row :: "+lastColSize);
		
//here I have to decide size of the array because Array is fixed size so i have to do this 
		
		int rowSize=lastRowSize-startRowNum; // but this is starts with where ever we want  
	// here I'm implementing the  line for given row number is exceed form that sheet 
//--------------------------------------------------------------------------------------------------
			if(rowSize<0)
			{
			System.out.println("*************************************************************");
			System.out.println("No Rows are available for getting the data form Excel sheet ");
			System.out.println("Actual    Rows    are     available : "+lastRowSize);
			System.out.println("But You wantnGet the  Data from rown: "+startRowNum);
			System.out.println("Miss match  thing  will  happen  so   I    decided   about  this ");
			System.out.println("If you want to get the data from excel sheet row Number must be <="+lastRowSize);
			System.out.println("*************************************************************");
			System.out.println("I want to exit from this this Program  ");
			try {Thread.sleep(2000); } catch (InterruptedException e) {	e.printStackTrace();	}
			System.exit(0);
			System.out.println("*************************************************************");
			System.out.println("System Running  is exit from the Program is terminated  ");
			System.out.println("*************************************************************");
			}
			
//--------------------------------------------------------------------------------------------------			

			int colSize=lastColSize-1;    ///// Check this working 
		//						String [lastRowNum+1][lastColNum+1] ;  later I will specify 
		String rowsData[][]=new String[rowSize+1][colSize+1]; // five rows 4 columns data I want how to get that data 
// for get the data from 
		DataFormatter df=new DataFormatter();// inside the data initially the data in cell in the form of objects
		
		for(int i=0; i<=rowSize;i++) // <= or < only later on 
 		{
			row=sheet.getRow(startRowNum); // Data is taken from  which row number 
			System.out.println("I get the Details  form Row : "+startRowNum);
			startRowNum+=1; // For next row getting the values  
			System.out.println("-------------------------------------------");
			
			for(int j=0; j<=colSize;j++) //Check here also <= or < only latter on 
			{
				cell=row.getCell(j); // data is taken from which column number 
				rowsData[i][j]=df.formatCellValue(cell);
				System.out.println("data  is taken from excelSheet : :"+rowsData[i][j]);
			}
			System.out.println("-------------------------------------------------");
			
		}
		
		System.out.println("Data is taken in 2-D Array ");
		for(int i=0;i<=rowSize;i++)
		{
			for(int j=0;j<=colSize;j++)
			{
				System.out.print(rowsData[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("--------------------------------------------------------");
	}
	
	public void getRowData(int rowNum) // rowNum=0 How to get the data 
	{
		int cellNum=0; //because columns values starts with 0 
		String[] rowData=new String[4]; // size of the 	String array is equal to number of columns later I will update	
										// Here I have to declare number if columns in  that sheet
										// then only it will work  exact number of columns in that sheet  
		DataFormatter df=new DataFormatter();
		
		//sheet=row.getRowNum(rowNum);
		
		row=sheet.getRow(rowNum);
		System.out.println("I get the row form the sheet ");
		cell=row.getCell(cellNum);
		String zero=df.formatCellValue(cell); // convert into string type 
		for(int i=0;i<rowData.length;i++)
		{
			cell=row.getCell(i);
			System.out.println(df.formatCellValue(cell)+ " is going to store in an Array ");
			rowData[i]=df.formatCellValue(cell);
			System.out.println(rowData[i]+" \t is Stored in an Array " );
		}
		
		System.out.println("All columns values are taken in an Array check the details ");
		for(String data:rowData)
		{
			System.out.print(data+"\t");
		}
	}
	public void createNewSheet(String sheetName)// This functionality is working as per requirement 
	{
		sheet=wb.getSheet(sheetName);
		if(sheet!=null)
		{
			System.out.println("Sheet is already is available ");
			System.out.println("Check in that workbook ");
		}
		else
		{
			System.out.println("sheet is not available "
					+ "So As per your request This program is going to create a sheet with :"+sheetName);
			sheet=wb.createSheet(sheetName);
			try {
				fos=new FileOutputStream(exFilePath);
				System.out.println("For writing the data workbook is loaded ");
				
				wb.write(fos);
				System.out.println("new things are updated in that workbook check in that workbook ");
			} catch (FileNotFoundException e) {
				System.out.println("For writing the data workbook is  Not loaded Properly check once ");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("unable to create New sheet  in that work book check what is the problem  ");
					e.printStackTrace();
			}
			
			System.out.println("Sheet is created in ::"+exFilePath+" with sheetName:: "+sheetName);
			System.out.println("Go and check it over there ");
	
		}
	}
	public void deleteSheet(String sheetName)// working as per expectations  with more concentration 
	{
	//	sheet=wb.createSheet(sheetName);
		sheet=wb.getSheet(sheetName);
		if(sheet!=null)
		{
			int numSheets=wb.getNumberOfSheets();
		System.out.println("number of sheets are availabel in this workbook : "+numSheets);
		int sheetIndex=wb.getSheetIndex(sheetName);
		System.out.println("If you want to remove this sheet form this workbook ");
		System.out.println("----------------------------------------------------");
		System.out.print("Enter option Yes or No :: ");
		String opt=s.next();
		
		System.out.println();
				if(opt.equalsIgnoreCase("yes"))
				{
				wb.removeSheetAt(sheetIndex);
				System.out.println(sheetName+" Is removed  at workbook");
				try {
					fos=new FileOutputStream(exFilePath);
					System.out.println("file is loaded for manipu;ation saving purpose ");
					wb.write(fos);
					System.out.println("remove  Sheet from the work book Please chek in workbook ");
				
				} catch (FileNotFoundException e) {
				System.out.println("File is not loaded properly please check in that ");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Unable to write your manipu;ations  plese cross check where is the problem ");
					e.printStackTrace();
				}
				
				}
				else
				{System.out.println(" As per your option sheet is not deleted in that workbook ");		}
				
		}
		else
		{	System.out.println("That sheet is not available is the workbook ");}
		
	}
	//************************   Main method is start here   **************************************
	public static void main(String[] args) {
		String exFilePath="";
	ExcelTest et=new ExcelTest(exFilePath);
//	ExcelTest et=new ExcelTest();
	et.getLastRowCount("sheet1");
	//et.getLastColCount(1);
	
	//et.getCellData(0, 0);	// this is belongs to first Row and First column 
	//et.setCellData("Venkat", 0, 0);
	//et.getRowData(0);
	//et.setCellData("Venkat", 11, 0);
	
	et.RowsDataGet("Sheet1",2); //It's working   I'm getting the data from form required specified Row  
	
	//et.createNewSheet("sheet2");
	//try {Thread.sleep(2000);} catch (InterruptedException e) { 	e.printStackTrace();}
	//et.deleteSheet("sheet2");
	
	}

}
