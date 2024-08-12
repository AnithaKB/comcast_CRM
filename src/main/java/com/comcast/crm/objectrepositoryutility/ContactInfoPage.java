package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id=\"dtlview_Last Name\"]")
	private WebElement lastName;

	@FindBy(xpath = "//span[@id=\"dtlview_Support Start Date\"]")
	private WebElement startDate;

	@FindBy(xpath = "//span[@id=\"dtlview_Support End Date\"]")
	private WebElement endDate;
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement conctHeader;

	@FindBy(xpath = "//td[@id=\"mouseArea_Organization Name\"]")
	private WebElement orgName;
	
	
	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getConctHeader() {
		return conctHeader;
	}

	public WebElement getOrgName() {
		return orgName;
	}
	
	
	
}
