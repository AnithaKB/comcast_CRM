package practice.datadriventesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		// step 1 : get the excel path location & java object of the physical Excelfile
		FileInputStream fis=new FileInputStream("D:\\ANITHA\\OFFICIAL\\TEK PYRAMID\\ADVANCE SELENIUM\\Book1.xlsx");
		
		// step 2 : open WorkBook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
		// step 3 : get the control of the "org" sheet
		Sheet sh = wb.getSheet("org");
		
		// step 4 : get the control of the "1st" row
		Row row = sh.getRow(1);
		
		// step 5 : get the control of the "2nd" cell & read the String data
//		Cell cel = row.getCell(1);
//		String data = cel.getStringCellValue();
		String data = row.getCell(3).toString();
		System.out.println(data);
		
		// step 6 : close the WorkBook 
		wb.close();
		
	}

}
