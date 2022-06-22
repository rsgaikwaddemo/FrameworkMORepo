package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
		
	XSSFWorkbook wb;
	
		public ExcelDataProvider() {
			
			FileInputStream fis;
			try {
				fis = new FileInputStream("./TestData/Data.xlsx");
				
				wb = new XSSFWorkbook(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Anable to read excel file"+e.getMessage());	
			}
		}
		
		
		//Method Overloading
		public String getStringData(String sheetName, int row, int cloumn) {
			
			return wb.getSheet(sheetName).getRow(row).getCell(cloumn).getStringCellValue();
		}
		
		public double getStringNumericData(String sheetName, int row, int cloumn) {
					
					return wb.getSheet(sheetName).getRow(row).getCell(cloumn).getNumericCellValue();
		}
		
		public String getStringData(int sheetIndex, int row, int cloumn) {
					
					return wb.getSheetAt(sheetIndex).getRow(row).getCell(cloumn).getStringCellValue();
		}
}
