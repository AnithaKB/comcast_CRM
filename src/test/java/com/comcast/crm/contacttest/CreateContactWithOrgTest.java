package com.comcast.crm.contacttest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContctPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void createContactWithOrgTest() throws Throwable {
		
			//read common data from cmd line
	    String BROWSER = flib.getDataFromPropertiesFile("browser");
	    String URL = flib.getDataFromPropertiesFile("url");
	    
	    
	    // read testscript data from Excel file
        String orgName = elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
        String contactLastName = elib.getDataFromExcel("contact", 7, 3);
	    

	    //step 1 : Login to app
	    driver.get(URL);
	    wlib.pageMaximize(driver);
	    wlib.waitForPageToLoad(driver);		
	    
		
		//step 2 : navigate to organization module		
		//step 3 : click on "create Organization" button 
		HomePage hp=new HomePage(driver);
		hp.ClickOrgLink();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.ClickOrgPlusSign();
		
		//step 4 : enter all the details & create new organization
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createOrganization(orgName);
		Thread.sleep(2000);
		
		//verify Header msg Expected result
		OrganizationInfoPage oif=new OrganizationInfoPage(driver);
		String headerinfo=oif.getHeaderInfo().getText();
		if(headerinfo.contains(orgName)) {
			System.out.println(orgName+" header is verified==PASS");
		}else {
			System.out.println(orgName+" header is not verified==FAIL");
		}
			
		//step 5 : navigate to contactmodule
		hp.ClickContactLink();
		
		//step 6 : click on "create contact" button 
		ContactsPage cp=new ContactsPage(driver);
		cp.ClickContctPlusSign();
		
		CreateNewContctPage ccop=new CreateNewContctPage(driver);
		ccop.createContactWithOrg(contactLastName, orgName);
		//step 7 : enter all the details & create new contact
//		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
//		driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();
		
		//switch to child Window
		
		
//		driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(orgName);
//		driver.findElement(By.xpath("//input[@name=\"search\"]")).click();
		
		
		//switch to parent Window
		
		
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(2000);
		
				
		//verify Header msg Expected result
	    ContactInfoPage cip=new ContactInfoPage(driver);
	    String contactheaderInfo=cip.getConctHeader().getText();
		
//		String contactheaderInfo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(contactheaderInfo.contains(contactLastName)) {
			System.out.println(contactLastName+" info is verified==PASS");
		}else {
			System.out.println(contactLastName+" info is not verified==FAIL");
		}
		
		//verify Header orgName into Expected result
		String actOrgName =cip.getOrgName().getText();
//		String actOrgName = driver.findElement(By.xpath("//td[@id=\"mouseArea_Organization Name\"]")).getText();
		if(actOrgName.contains(orgName)) {
			System.out.println(orgName+" info is verified==PASS");
		}else {
			System.out.println(orgName+" info is not verified==FAIL");
		}
		
	}

}
