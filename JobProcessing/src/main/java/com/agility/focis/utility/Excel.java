package com.agility.focis.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.agility.focis.testData.Constant;

public class Excel {

	// To read xlsx files use XSSF and for xls use HSSF
	  private static XSSFWorkbook Wb;
	  private static XSSFSheet Ws;
	  private static XSSFCell cell;
	  private static XSSFRow row;
	
	  // To open the excel file
	public static void setExcelFile(String path,String SheetName) throws Exception {
		
		try {
		
		FileInputStream fip=new FileInputStream(path+SheetName);
		Wb=new XSSFWorkbook(fip);
	    Ws=Wb.getSheet("Credentails");
	    		
		}
	   catch(Exception e) {
		   
		   e.printStackTrace();
	   }
	}
	
	public static String getCellData(int rowno,int colno) {
		
		try {
			cell=Ws.getRow(rowno).getCell(colno);
            String cellData=	cell.getStringCellValue();
           return cellData;
		} catch (Exception e) {
			
			return "";
		}
	   
	 
	}
	public static void setCellData(String Result,int rowno,int colno) throws Exception {
		
		try {
		row=Ws.getRow(rowno);
		cell=row.getCell(colno);
		if(cell==null) {
			
			cell=row.createCell(colno);
			cell.setCellValue(Result);
		}
		else {
			
			cell.setCellValue(Result);
		}
		
		FileOutputStream fout=new FileOutputStream(Constant.Path_TestData+Constant.File_TestData);
		Wb.write(fout);
		fout.flush();
		fout.close();
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}
}
}