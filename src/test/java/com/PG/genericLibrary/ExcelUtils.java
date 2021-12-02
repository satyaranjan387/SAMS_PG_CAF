package com.PG.genericLibrary;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	public Object[][] gettingDistrictwisewomenscollegedata(String CollegeName) throws Exception
	{
	FileInputStream fis= new FileInputStream("C:\\Users\\milan.singh\\eclipse-workspace\\SAMSDegree\\WomensCollege.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet("CheckDistrict");
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	
	}
	
	
	public Object[][] gettingHostelFacilityDisplayData(String CollegeName) throws Exception
	{
	FileInputStream fis= new FileInputStream("C:\\Users\\milan.singh\\eclipse-workspace\\SAMS Junior\\HostelFacility.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet("CheckHostelFacility");
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	
	}
	
	public Object[][] gettingUploadImage(String UploadImage) throws Exception
	{
	FileInputStream fis= new FileInputStream("C:\\Users\\milan.singh\\eclipse-workspace\\SAMS Junior\\VerifyUploadImage.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet("Checkuploadimage");
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	
	}
	
	
	
	public Object[][] gettingInvalidUploadImage(String UploadImage) throws Exception
	{
	FileInputStream fis= new FileInputStream("C:\\Users\\milan.singh\\eclipse-workspace\\SAMS Junior\\VerifyUploadImageInValidFile.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet("Checkuploadimage");
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	
	}
	
	
	
	public Object[][] gettingAutovalidation(String Rollno) throws Exception
	{
	FileInputStream fis= new FileInputStream("C:\\Users\\satyaranjan.m\\eclipse-workspace\\DegreeForm\\AutovalidationDegree.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	XSSFSheet sh= workbook.getSheet("CheckAutoValidation");
	System.out.println("number of sheet:"+sheets);
	Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	
	}
	
	
	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
				cell.setCellValue(data);

			fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
