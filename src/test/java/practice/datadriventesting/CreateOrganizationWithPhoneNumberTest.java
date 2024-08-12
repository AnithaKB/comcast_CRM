package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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

public class CreateOrganizationWithPhoneNumberTest {

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
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(7);
		
		String orgName = row.getCell(2).toString()+randomNum;
		String phoneNumber = row.getCell(3).getStringCellValue();
		System.out.println(orgName);
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
		
		//step 2 : navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 3 : click on "create Organization" button 
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
		//step 4 : enter all the details & create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys(phoneNumber);
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(2000);
		
				
		//verify Header orgName into Expected result
		String actPhoneNumber = driver.findElement(By.xpath("//span[@id=\"dtlview_Phone\"]")).getText();
		if(actPhoneNumber.contains(phoneNumber)) {
			System.out.println(phoneNumber+" is verified==PASS");
		}else {
			System.out.println(phoneNumber+" is not verified==FAIL");
		}

		
		//step 5 : logout
		Actions act=new Actions(driver);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),\"Sign Out\")]"))).click().perform();
		
				
		driver.quit();


	}

}
