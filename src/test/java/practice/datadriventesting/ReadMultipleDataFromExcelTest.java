package practice.datadriventesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis=new FileInputStream("D:\\ANITHA\\OFFICIAL\\TEK PYRAMID\\ADVANCE SELENIUM\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		
		int rowCount=sh.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++) {
			Row row = sh.getRow(i);
		 String column1Data = row.getCell(0).toString();
		 String column2Data = row.getCell(1).toString();
		 System.out.println(column1Data+"\t"+column2Data);
		}
		 wb.close();
	}

}
