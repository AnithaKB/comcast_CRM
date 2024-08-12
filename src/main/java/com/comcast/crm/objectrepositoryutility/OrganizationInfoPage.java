package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement headerInfo;
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement actOrgName;
	
	@FindBy(xpath = "//span[@id=\"dtlview_Industry\"]")
	private WebElement actIndustries;
	
	@FindBy(xpath = "//span[@id=\"dtlview_Type\"]")
	private WebElement actType;
	
	@FindBy(xpath = "//span[@id=\"dtlview_Phone\"]")
	private WebElement actPhoneNumber;
	
	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}

	public WebElement getActIndustries() {
		return actIndustries;
	}

	public WebElement getActType() {
		return actType;
	}

	public WebElement getActPhoneNumber() {
		return actPhoneNumber;
	}
	
}
	//Business logics
	//verify Header msg Expected result
//	public void getHeaderInfoText(String orgName) {
//		headerInfo;
//		if(headerInfo.equals(orgName)) {
//			System.out.println(orgName+" is verified==PASS");
//		}else {
//			System.out.println(orgName+" is not verified==FAIL");
//		}
//	}
	
	//verify Header orgName into Expected result
//	public void getActOrgNameText(String orgName) {
//		actOrgName.getText();
//		if(actOrgName.equals(orgName)) {
//			System.out.println(orgName+" is created==PASS");
//		}else {
//			System.out.println(orgName+" is not created==FAIL");
//		}
	
	
	


