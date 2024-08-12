package practice.datadriventesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRunTime {

	@Test
	public void seleniumTest() throws Throwable {
		// read common data from property file
        
	
	    String BROWSER = "";
	    String URL = "";
	    String USERNAME =""; 
	    String PASSWORD = "";
	    
 WebDriver driver=null;
	    
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
//		
//		//step 4 : enter all the details & create new organization
//		driver.findElement(By.name("accountname")).sendKeys(orgName);
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
//		Thread.sleep(2000);
//		//step 5 : logout
//		Actions act=new Actions(driver);
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		Thread.sleep(2000);
//		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),\"Sign Out\")]"))).click().perform();
//		driver.quit();

	}
		
	}


