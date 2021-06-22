package utilities;        //Do not change the package name

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExcelUtils {        
public static XSSFSheet worksheet;
public static XSSFWorkbook workbook;
public static FileInputStream work_file;
public static String file_path;

	public static String[] readExcelDataForDetails(String sheetName) throws Exception {
		file_path=System.getProperty("user.dir")+"\\IssuesDetails.xlsx";
		work_file = new FileInputStream(file_path);
		workbook = new XSSFWorkbook(work_file);
		worksheet =  workbook.getSheet(sheetName);
		String[] data=new String[10];
		XSSFRow row=worksheet.getRow(1);
		XSSFCell cell;
		
		for(int index=0;index<10;index++)
		{
			cell=row.getCell(index);
			data[index]=cell.toString();
		}
		
        return data;
        
	   	}
	
	public static String[] readExcelDataForWorkflow(String sheetName) throws Exception {
		file_path=System.getProperty("user.dir")+"\\IssuesDetails.xlsx";
		work_file = new FileInputStream(file_path);
		workbook = new XSSFWorkbook(work_file);
		worksheet =  workbook.getSheet(sheetName);
		String[] data=new String[3];
		XSSFRow row=worksheet.getRow(4);
		XSSFCell cell;
		
		for(int index=0;index<3;index++)
		{
			cell=row.getCell(index);
			data[index]=cell.toString();
		}
		
        return data;
        
	   	}

}






