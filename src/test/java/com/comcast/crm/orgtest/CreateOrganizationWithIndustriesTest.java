package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtil;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithIndustriesTest {

	@Test
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
        String orgName=elib.getDataFromExcel("org", 4, 2)+jlib.getRandomNumber();
        String industry=elib.getDataFromExcel("org", 4, 3);
        String type=elib.getDataFromExcel("org", 4, 4);
        
		
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
		lp.LoginToApp(URL,USERNAME,PASSWORD);
	    
		//step 2 : navigate to organization module
		//step 3 : click on "create Organization" button 
		HomePage hp=new HomePage(driver);
		hp.ClickOrgLink();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.ClickOrgPlusSign();
		
		//step 4 : enter all the details & create new organization
		CreateNewOrganizationPage cwi=new CreateNewOrganizationPage(driver);
		cwi.getOrganiWithInd(orgName, industry, type);
		
		Thread.sleep(2000);
		
		//verify the industries and type info
		OrganizationInfoPage oif=new OrganizationInfoPage(driver);
		String actIndustries = oif.getActIndustries().getText();
		if(actIndustries.contains(industry)) {
			System.out.println(industry+" information is verified==PASS");
		}else {
			System.out.println(industry+" information is not verified==FAIL");
		}
		
		String actType =oif.getActType().getText();
		if(actType.contains(type)) {
			System.out.println(type+" information is verified==PASS");
		}else {
			System.out.println(type+" information is not verified==FAIL");
		}

		
		//step 5 : logout
		hp.SignOutFromApp();
		driver.quit();


	}

}
