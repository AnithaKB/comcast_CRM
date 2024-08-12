package com.comcast.crm.contacttest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContctPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactWithSupportDateTest extends BaseClass {

	@Test
	
	public void createContactWithSupportDateTest() throws Throwable {
		
		//read common data from cmd line
	    String BROWSER = flib.getDataFromPropertiesFile("browser");
	    String URL = flib.getDataFromPropertiesFile("url");
	    
	    
	    // read testscript data from Excel file
        String lastName=elib.getDataFromExcel("contact", 4, 2)+jlib.getRandomNumber();
        
	   
	    //step 1 : Login to app
	    driver.get(URL);
	    wlib.pageMaximize(driver);
	    wlib.waitForPageToLoad(driver);
	    
	    
		//step 2 : navigate to contactmodule
		HomePage hp=new HomePage(driver);
		hp.ClickContactLink();
		
		//step 3 : click on "create contact" button 
		ContactsPage cp=new ContactsPage(driver);
		cp.ClickContctPlusSign();
		
		//step 4 : enter all the details & create new contact
		String startDate = jlib.getSystemDateYYYYDDMM();
		String endDate = jlib.getRequiredDateYYYYDDMM(+30);
		
		CreateNewContctPage csdp=new CreateNewContctPage(driver);
		csdp.createContactWithSprt(lastName, startDate, endDate);
		Thread.sleep(2000);
				
		//verify Header startDate into Expected result
		ContactInfoPage cif=new ContactInfoPage(driver);
		String actStartDate =cif.getStartDate().getText();
		if(actStartDate.contains(startDate)) {
			System.out.println(startDate+" information is verified==PASS");
		}else {
			System.out.println(startDate+" information is not verified==FAIL");
		}
		
		//verify Header endDate into Expected result
		
		String actEndDate =cif.getEndDate().getText();
		if(actEndDate.contains(endDate)) {
			System.out.println(endDate+" information is verified==PASS");
		}else {
			System.out.println(endDate+" information is not verified==FAIL");
		}
		
		//step 5 : logout
			
	}

}
