package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganizationTest() throws Throwable {
		wlib.waitForPageToLoad(driver);
	    
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
	    // read testscript data from Excel file
		String orgName=elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNumber();
     
		//step 2 : navigate to organization module
		//step 3 : click on "create Organization" button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org page");
		HomePage hp=new HomePage(driver);
		hp.ClickOrgLink();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.ClickOrgPlusSign();
		
		//step 4 : enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, "create a new Org");
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createOrganization(orgName);
		Thread.sleep(2000);
		
		UtilityClassObject.getTest().log(Status.INFO,orgName+ "create a new Org");

		//verify Header msg Expected result
		OrganizationInfoPage oif=new OrganizationInfoPage(driver);
		String headerinfo=oif.getHeaderInfo().getText();
		boolean status = headerinfo.contains(orgName);
		Assert.assertEquals(status, true);
		
		
		//verify Header orgName into Expected result
		
		String actOrgName=oif.getActOrgName().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actOrgName, orgName);
			
	}
	
	@Test
	public void createOrganizationWithIndustriesTest() throws Throwable {
		wlib.waitForPageToLoad(driver);
	    // read testscript data from Excel file
        String orgName=elib.getDataFromExcel("org", 4, 2)+jlib.getRandomNumber();
        String industry=elib.getDataFromExcel("org", 4, 3);
        String type=elib.getDataFromExcel("org", 4, 4);
        

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
		boolean status = actIndustries.contains(industry);
		Assert.assertEquals(status, true);
		
		String actType =oif.getActType().getText();
		boolean status1 = actType.contains(type);
		Assert.assertEquals(status1, true);
		
	}
	
	@Test
	public void CreateOrganizationWithPhoneNumberTest() throws Throwable {
	
		wlib.waitForPageToLoad(driver);
	    // read testscript data from Excel file
        String orgName=elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
        String phoneNumber=elib.getDataFromExcel("org", 7, 3);
		
		HomePage hp=new HomePage(driver);
		hp.ClickOrgLink();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.ClickOrgPlusSign();
		
		//step 4 : enter all the details & create new organization
		CreateNewOrganizationPage cwp=new CreateNewOrganizationPage(driver);
		cwp.getOrganiWithPhone(orgName, phoneNumber);
		
		Thread.sleep(2000);
		
				
		//verify Header orgName into Expected result
//		String actPhoneNumber = driver.findElement(By.xpath("//span[@id=\"dtlview_Phone\"]")).getText();
		OrganizationInfoPage oif=new OrganizationInfoPage(driver);
		String actPhoneNumber =oif.getActPhoneNumber().getText();
		boolean status = actPhoneNumber.contains(phoneNumber);
		Assert.assertEquals(status, true);
		
	}

}
