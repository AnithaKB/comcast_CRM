package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtil;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public FileUtility flib=new FileUtility();
	public ExcelUtil elib=new ExcelUtil();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public DataBaseUtility dblib=new DataBaseUtility();
    public WebDriver driver;
    public static WebDriver sdriver;
    
    
	@BeforeSuite(groups={"smokeTest", "regressionTest"})
	public void configBS() {
		System.out.println("==Connect to DB, Report Config==");
		dblib.getDbconnection();
		
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups ={"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
		System.out.println("==Launch the browser==");
//		String BROWSER = browser;
		String BROWSER = flib.getDataFromPropertiesFile("browser");
	    
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
	    sdriver=driver;
	}
	
	@BeforeMethod(groups ={"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		wlib.waitForPageToLoad(driver);
		System.out.println("==login==");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
	    String PASSWORD = flib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(URL,USERNAME, PASSWORD);
		
	}

	@AfterMethod(groups ={"smokeTest","regressionTest"})
	public void configAM() throws Throwable {
		System.out.println("==logout==");
		HomePage hp=new HomePage(driver);
		hp.SignOutFromApp();
	}
	
	@AfterClass(groups ={"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("==close the browser==");
		driver.quit();
	}

	@AfterSuite(groups ={"smokeTest","regressionTest"})
	public void configAF() {
		System.out.println("==close DB, Report backup==");
		
	}

}
