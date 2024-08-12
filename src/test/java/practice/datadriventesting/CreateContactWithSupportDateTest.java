package practice.datadriventesting;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws Throwable {
		// read common data from property file
        FileInputStream fis=new FileInputStream("D:\\ANITHA\\OFFICIAL\\TEK PYRAMID\\ADVANCE SELENIUM\\VtigerData.properties");
	    Properties pObj=new Properties();
	    pObj.load(fis);
	
		//read common data from cmd line
	    String BROWSER = pObj.getProperty("browser");
	    String URL = pObj.getProperty("url");
	    String USERNAME = pObj.getProperty("username");
	    String PASSWORD = pObj.getProperty("password");
	    
	    //generate random number
	    Random random=new Random();
      int randomNum=random.nextInt(1000);
	    
	    // read testscript data from Excel file
      FileInputStream fis1=new FileInputStream("D:\\ANITHA\\OFFICIAL\\TEK PYRAMID\\ADVANCE SELENIUM\\Book1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(4);
		
		String lastName = row.getCell(2).toString()+randomNum;
		System.out.println(lastName);
		wb.close();
		
	    WebDriver driver=null;
	    //polymorphism
	    if(BROWSER.equals("chrome")) {
	    	driver=new ChromeDriver();
	    }else if(BROWSER.equals("firefox")) {
	    	driver=new FirefoxDriver();
	    }else if (BROWSER.equals("edge")) {
	    	driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}

	    //step 1 : Login to app
	    driver.get(URL);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step 2 : navigate to contactmodule
		driver.findElement(By.linkText("Contacts")).click();
		
		//step 3 : click on "create contact" button 
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		//step 4 : enter all the details & create new contact
        Date dateObj=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startDate=sim.format(dateObj);
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String endDate = sim.format(cal.getTime());
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(2000);
				
		//verify Header startDate into Expected result
		String actStartDate = driver.findElement(By.xpath("//span[@id=\"dtlview_Support Start Date\"]")).getText();
		if(actStartDate.contains(startDate)) {
			System.out.println(startDate+" information is verified==PASS");
		}else {
			System.out.println(startDate+" information is not verified==FAIL");
		}
		
		//verify Header endDate into Expected result
		String actEndDate = driver.findElement(By.xpath("//span[@id=\"dtlview_Support End Date\"]")).getText();
		if(actEndDate.contains(endDate)) {
			System.out.println(endDate+" information is verified==PASS");
		}else {
			System.out.println(endDate+" information is not verified==FAIL");
		}
		
		//step 5 : logout
		Actions act=new Actions(driver);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),\"Sign Out\")]"))).click().perform();
		
				
		driver.quit();		
	}

}
