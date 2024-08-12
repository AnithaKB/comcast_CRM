package com.pack1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateOrgTest extends com.comcast.crm.basetest.BaseClass{
	
	
	@Test
	public void createContact() {
		System.out.println("execute createOrgtest & verify");
	}
	
	@Test
	public void createContactWithDate() {
		System.out.println("execute createOrgwithIndustries & verify");
	}
	
		
}
