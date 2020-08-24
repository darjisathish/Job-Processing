package com.agility.focis.datadriven;

import java.io.FileInputStream;



import com.agility.focis.testData.Constant;
import com.agility.focis.utility.Excel;

public class LoginWithMultipleUsers {

	  private static XSSFWorkbook Wb;
	  private static XSSFSheet Ws;
	  private static XSSFCell cell;
	  private static XSSFRow row;
	  
	public static void main(String[] args) throws Exception {
		
	     
		FileInputStream fip=new FileInputStream(Constant.Path_TestData+Constant.File_TestData);
		Wb=new XSSFWorkbook(fip);
	    Ws=Wb.getSheet("Credentails");
	      
	      int rowsCount=Ws.getLastRowNum()-Ws.getFirstRowNum();
	      System.err.println("The rows count is "+rowsCount);

	}

}
