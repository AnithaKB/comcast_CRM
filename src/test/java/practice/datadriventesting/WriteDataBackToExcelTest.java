package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcelTest {
	public static void main(String[] args) throws Throwable {
		//read mode
		FileInputStream fis=new FileInputStream("D:\\ANITHA\\OFFICIAL\\TEK PYRAMID\\ADVANCE SELENIUM\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		Cell cell = row.createCell(4);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("FAIL");
		
		//write mode
		FileOutputStream fos= new FileOutputStream("D:\\ANITHA\\OFFICIAL\\TEK PYRAMID\\ADVANCE SELENIUM\\Book1.xlsx");
		wb.write(fos);
	    wb.close();
		System.out.println("=====Executed=====");
		
	}

}
