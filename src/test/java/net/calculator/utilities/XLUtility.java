package net.calculator.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	String path = null;
	
	public XLUtility(String path){
		this.path = path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		
		return rowcount;
	}
	
	public int getCellCount(String sheetName, int rowNum ) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;		
	}
	
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			 
			data = "";
		}
		workbook.close();
		fi.close();
		return data;		
	}
	
	public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();	
	}
	
}
