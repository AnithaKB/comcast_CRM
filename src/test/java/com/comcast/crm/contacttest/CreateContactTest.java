package com.comcast.crm.contacttest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContctPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateContactTest extends BaseClass {
	
    
	@Test
	public void createContactTest() throws Throwable {
		
		// read testscript data from Excel file
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();


		// step 2 : navigate to contactmodule
		HomePage hp = new HomePage(driver);
		hp.ClickContactLink();
		Assert.fail();
		// step 3 : click on "create contact" button

		ContactsPage cp = new ContactsPage(driver);
		cp.ClickContctPlusSign();

		// step 4 : enter all the details & create new contact
		CreateNewContctPage ccp = new CreateNewContctPage(driver);
		ccp.createContact(lastName);
		Thread.sleep(2000);

		// verify Header lastName into Expected result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactheaderInfo=cip.getConctHeader().getText();
		boolean status = contactheaderInfo.contains(lastName);
		Assert.assertEquals(status, true);
		
		String actLastName = cip.getLastName().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName, lastName);
				
	}
	
	@Test
	public void createContactWithOrgTest() throws Throwable {
		 
	    // read testscript data from Excel file
        String orgName = elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
        String contactLastName = elib.getDataFromExcel("contact", 7, 3);
	    
		
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
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(headerinfo, orgName);
		
			
		//step 5 : navigate to contactmodule
		hp.ClickContactLink();
		
		//step 6 : click on "create contact" button 
		ContactsPage cp=new ContactsPage(driver);
		cp.ClickContctPlusSign();
		
		CreateNewContctPage ccop=new CreateNewContctPage(driver);
		ccop.createContactWithOrg(contactLastName, orgName);
		//step 7 : enter all the details & create new contact

		Thread.sleep(2000);
		
				
		//verify Header msg Expected result
	    ContactInfoPage cip=new ContactInfoPage(driver);
	    String contactheaderInfo=cip.getConctHeader().getText();
		
//		String contactheaderInfo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	    boolean status = contactheaderInfo.contains(contactLastName);
		Assert.assertEquals(status, true);
		
		//verify Header orgName into Expected result
		String actOrgName =cip.getOrgName().getText();
//		String actOrgName = driver.findElement(By.xpath("//td[@id=\"mouseArea_Organization Name\"]")).getText();
		SoftAssert soft1=new SoftAssert();
		soft1.assertEquals(actOrgName, orgName);
		
	}
	
@Test
	
	public void createContactWithSupportDateTest() throws Throwable {
		
	    
	    // read testscript data from Excel file
        String lastName=elib.getDataFromExcel("contact", 4, 2)+jlib.getRandomNumber();
	    
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
		boolean status = actStartDate.contains(startDate);
		Assert.assertEquals(status, true);
		
		
		//verify Header endDate into Expected result
		
		String actEndDate =cif.getEndDate().getText();
		boolean status1 = actEndDate.contains(endDate);
		Assert.assertEquals(status1, true);
			
	}

}
