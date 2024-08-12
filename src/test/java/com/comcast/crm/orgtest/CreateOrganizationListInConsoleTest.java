package com.comcast.crm.orgtest;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtil;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationListInConsoleTest {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtil elib=new ExcelUtil();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
      
		//read common data from cmd line
	    String BROWSER = flib.getDataFromPropertiesFile("browser");
	    String URL = flib.getDataFromPropertiesFile("url");
	    String USERNAME = flib.getDataFromPropertiesFile("username");
	    String PASSWORD = flib.getDataFromPropertiesFile("password");
	    
	    
	    // read testscript data from Excel file
      String orgName=elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNumber();
      
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
	    wlib.pageMaximize(driver);
	    wlib.waitForPageToLoad(driver);
	    
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(URL,USERNAME, PASSWORD);
		
		//step 2 : navigate to organization module
		//step 3 : click on "create Organization" button
		HomePage hp=new HomePage(driver);
		hp.ClickOrgLink();
		
		
		//step 4 : enter all the organization list in console
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getOrgListInConsole();
		
//		//verify Header msg Expected result
//		OrganizationInfoPage oif=new OrganizationInfoPage(driver);
//		String headerinfo=oif.getHeaderInfo().getText();
//		if(headerinfo.contains(orgName)) {
//			System.out.println(orgName+" is verified==PASS");
//		}else {
//			System.out.println(orgName+" is not verified==FAIL");
//		}
//		
//		//verify Header orgName into Expected result
//		
//		String actOrgName=oif.getActOrgName().getText();
//		if(actOrgName.contains(orgName)) {
//			System.out.println(orgName+" is created==PASS");
//		}else {
//			System.out.println(orgName+" is not created==FAIL");
//		}
		
		//step 5 : logout
		hp.SignOutFromApp();
	
		driver.quit();
		
	}

}
