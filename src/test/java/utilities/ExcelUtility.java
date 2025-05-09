package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int getRowCount(String Sheetname) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(Sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
		
	}
	
	
	
	public int getCellCount(String Sheetname, int Rownum) throws IOException {
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet= workbook.getSheet(Sheetname);
		row= sheet.getRow(Rownum);
		System.out.println(row);
		int cellcount =row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
		
	}
	
	
	public String getCellData(String Sheetname, int rowum, int colnum ) throws IOException {
		fi= new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(Sheetname);
		row = sheet.getRow(rowum);
		if (row == null) {
		    return ""; // Return empty string if row doesn't exist
		}

		cell = row.getCell(colnum);
		if (cell == null) {
		    return ""; // Return empty string if cell doesn't exist
		}

		//cell= sheet.getRow(rowum).getCell(colnum);
		
		DataFormatter formatter= new DataFormatter();
		String data;
		try {
		data=formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		
		workbook.close();
		fi.close();
		return data;	

}
	public void setCellData(String Sheetname, int rownum, int colnum, String data) throws IOException {
		File xlfile= new File(path);
		if(!xlfile.exists())
		{
			fo = new FileOutputStream(xlfile);
		    workbook=new XSSFWorkbook();
		    workbook.write(fo);		
			
		}
		
		fi= new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		if(workbook.getSheetIndex(Sheetname)==-1) 
			workbook.createSheet(Sheetname);
			sheet=workbook.getSheet(Sheetname);
			
		if(sheet.getRow(rownum)==null)	
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell= row.createCell(colnum);
		cell.setCellValue(data);
		fo= new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
	}
}
