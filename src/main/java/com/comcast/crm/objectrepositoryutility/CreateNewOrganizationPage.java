package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage {
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgTextfield;
	
	@FindBy(xpath = "//select[@name=\"industry\"]")
	private WebElement indDropdwn;
	
	@FindBy(xpath = "//select[@name=\"accounttype\"]")
	private WebElement typDropdwn;
	
	@FindBy(xpath = "//input[@name=\"phone\"]")
	private WebElement phoneNum;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getOrgTextfield() {
		return orgTextfield;
	}

	public WebElement getPhoneNum() {
		return phoneNum;
	}
	
	public WebElement getIndDropdwn() {
		return indDropdwn;
	}

	public WebElement getTypDropdwn() {
		return typDropdwn;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createOrganization(String orgName) {
		wlib.waitForPageToLoad(driver);
		orgTextfield.sendKeys(orgName);
		saveButton.click();
	}
	
	public void getOrganiWithPhone(String orgName, String phoneNumber){
		wlib.waitForPageToLoad(driver);
		orgTextfield.sendKeys(orgName);
		phoneNum.sendKeys(phoneNumber);
		saveButton.click();
	}
	
	public void getOrganiWithInd(String orgName, String industry, String type) throws Throwable {
		wlib.waitForPageToLoad(driver);
		orgTextfield.sendKeys(orgName);
		Thread.sleep(2000);
		wlib.select(indDropdwn, industry);
		wlib.select(typDropdwn, type);
		saveButton.click();
	}
	

}
