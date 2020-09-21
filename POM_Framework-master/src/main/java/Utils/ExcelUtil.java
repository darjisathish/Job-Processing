//package Utils;
//
//import org.apache.commons.math3.analysis.function.Constant;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Iterator;
//import java.io.FileOutputStream;
//
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelUtil {
//
//    private static XSSFSheet ExcelWSheet;
//    private static XSSFWorkbook ExcelWBook;
//    private static XSSFCell Cell;
//    private static XSSFRow Row;
//
//    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
//
//	public static void setExcelFile(String Path,String SheetName) throws Exception {
//		try {
//			// Open the Excel file
//			FileInputStream ExcelFile = new FileInputStream(Path);
//			// Access the required test data sheet
//			ExcelWBook = new XSSFWorkbook(ExcelFile);
//			ExcelWSheet = ExcelWBook.getSheet(SheetName);
//			} catch (Exception e){
//				throw (e);
//				}
//		}
//
//    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
//    public static String getCellData(int RowNum, int ColNum) throws Exception{
//
//        try{
//            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
//            String CellData = Cell.getStringCellValue();
//            return CellData;
//        }catch (Exception e){
//            return"";
//        }
//    }
//
//    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
//    public static String getCellData(int RowNum, String ColName) throws Exception{
//
//        int colNum=0;
//        for(int i=0;i<100;i++)
//        {
//            if(ExcelWSheet.getRow(0).getCell(i).getStringCellValue().equals(ColName))
//            {
//                colNum=i;
//                break;
//            }
//        }
//
//        try{
//            Cell = ExcelWSheet.getRow(RowNum).getCell(colNum);
//            String CellData = Cell.getStringCellValue();
//            return CellData;
//        }catch (Exception e){
//            return"";
//        }
//    }
//
//    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
//    @SuppressWarnings("deprecation")
//    public static void setCellData(String data,int RowNum, String ColName) throws Exception{
//
//        int colNum=0;
//        String bgColour="WHITE";
//
//        if(ColName.equals("Result")) {
//            if(data.equals("PASS")) {
//                bgColour="GREEN";
//            } else if (data.equals("FAIL")) {
//                bgColour="RED";
//            }
//        }
//
//        for(int i=0;i<100;i++) {
//            if(ExcelWSheet.getRow(0).getCell(i).getStringCellValue().equals(ColName)) {
//                colNum=i;
//                break;
//            }
//        }
//
//        try{
//            Row  = ExcelWSheet.getRow(RowNum);
//            Cell = Row.getCell(colNum, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
//            if (Cell == null) {
//                Cell = Row.createCell(colNum);
//                Cell.setCellValue(data);
//            } else {
//                Cell.setCellValue(data);
//            }
//            if(bgColour.equals("GREEN")) {
//                XSSFCellStyle style=ExcelWBook.createCellStyle();
//                style.setFillBackgroundColor(new XSSFColor(new java.awt.Color(0, 128, 0)));
//                Cell.setCellStyle(style);
//            } else if (bgColour.equals("RED")) {
//                XSSFCellStyle style=ExcelWBook.createCellStyle();
//                style.setFillBackgroundColor(new XSSFColor(new java.awt.Color(255,0,0)));
//                style.setFillPattern(FillPatternType.LEAST_DOTS);
//                Cell.setCellStyle(style);
//            }
//            FileOutputStream fileOut = new FileOutputStream(Constant.Path_ExcelReport + Constant.File_ExcelReport);
//            ExcelWBook.write(fileOut);
//            fileOut.flush();
//            fileOut.close();
//        }catch (Exception e){
//            throw (e);
//        }
//    }
//
//    //This method is to write in the Excel cell, Row num and Col num are the parameters
//    @SuppressWarnings("deprecation")
//    public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
//
//        try{
//            Row  = ExcelWSheet.getRow(RowNum);
//            Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
//            if (Cell == null) {
//                Cell = Row.createCell(ColNum);
//                Cell.setCellValue(Result);
//            } else {
//                Cell.setCellValue(Result);
//            }
//
//            // Constant variables Test Data path and Test Data file name
//            FileOutputStream fileOut = new FileOutputStream(Constant.Path_ExcelReport + Constant.File_ExcelReport);
//            ExcelWBook.write(fileOut);
//            fileOut.flush();
//            fileOut.close();
//        }catch(Exception e){
//            throw (e);
//        }
//    }
//
//    public static int getRows()
//    {
//        int rows=0;
//        rows = ExcelWSheet.getLastRowNum();
//        return rows;
//    }
//
//    public static void deleteRowWithFalseCheck() {
//        for (int i=0;i<=ExcelUtil.getRows();i++) {
//            try {
//                if(ExcelUtil.getCellData(i, "ToRun").toLowerCase().equals("fasle")) {
//                    ExcelWSheet.removeRow(ExcelWSheet.getRow(i));
//                    FileOutputStream fileOut = new FileOutputStream(Constant.Path_ExcelReport + Constant.File_ExcelReport);
//                    ExcelWBook.write(fileOut);
//                    fileOut.flush();
//                    fileOut.close();
//                }
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    static int getColumnNumber(String colName) {
//        int colNum=0;
//        for(int i=0;i<100;i++)
//        {
//            if(ExcelWSheet.getRow(0).getCell(i).getStringCellValue().equals(colName))
//            {
//                colNum=i;
//                break;
//            }
//        }
//        return colNum;
//    }
//}
