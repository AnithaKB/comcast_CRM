package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContctPage {
	
	WebDriverUtility wlib=new WebDriverUtility();
	WebDriver driver;
	public CreateNewContctPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTextfield;
	
	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement startDateTextfield;
	
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement endDateTextfield;
	
	@FindBy(xpath = "//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement orgPlusSign;
	
	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement orgSrchTxtFld;
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement orgSearchButton;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	public WebElement getStartDateTextfield() {
		return startDateTextfield;
	}

	public WebElement getEndDateTextfield() {
		return endDateTextfield;
	}

	public WebElement getOrgPlusSign() {
		return orgPlusSign;
	}

	public WebElement getOrgSrchTxtFld() {
		return orgSrchTxtFld;
	}

	public WebElement getOrgSearchButton() {
		return orgSearchButton;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createContact(String lastName) {
		wlib.waitForPageToLoad(driver);
		lastNameTextfield.sendKeys(lastName);
		saveButton.click();
	}
	
	public void createContactWithSprt(String lastName, String startDate, String endDate ) {
		wlib.waitForPageToLoad(driver);
		lastNameTextfield.sendKeys(lastName);
		startDateTextfield.clear();
		startDateTextfield.sendKeys(startDate);
		endDateTextfield.clear();
		endDateTextfield.sendKeys(endDate);
		saveButton.click();
	}
	
	public void createContactWithOrg(String lastName, String orgName) {
		wlib.waitForPageToLoad(driver);
		lastNameTextfield.sendKeys(lastName);
		orgPlusSign.click();
		wlib.switchToTabOnUrl(driver, "Accounts&action");
		orgSrchTxtFld.sendKeys(orgName);
		orgSearchButton.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wlib.switchToTabOnUrl(driver, "Contacts&action");
		saveButton.click();
	}

}
