package com.salesforce.dataprovider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	XSSFCell cell;
	public ExcelDataProvider()
	{
		File src = new File("./ApplicationTestData/AppData.xlsx");
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
	}
	
	public String getData(int SheetIndex,int row, int column)
	{
		DataFormatter formatter = new DataFormatter();
		cell = wb.getSheetAt(SheetIndex).getRow(row).getCell(column);
		String data= formatter.formatCellValue(cell);	
	//	String data  = wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public String getData(String SheetName,int row, int column)
	{
		DataFormatter formatter = new DataFormatter();
		cell = wb.getSheet(SheetName).getRow(row).getCell(column);
		String data= formatter.formatCellValue(cell);
	//	String data = wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public int getIntData(int SheetIndex,int row, int column)
	{	
	 int data  = (int) wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getNumericCellValue();
		return data;
	}
	
	
}

