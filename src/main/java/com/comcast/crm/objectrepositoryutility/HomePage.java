package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement SignOutImg;
	
	@FindBy(xpath = "//a[contains(text(),\"Sign Out\")]")
	private WebElement SignOutButton;

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getSignOutImg() {
		return SignOutImg;
	}

	public WebElement getSignOutButton() {
		return SignOutButton;
	}

	public void ClickOrgLink() {
		OrgLink.click();
	}
	
	public void ClickContactLink() {
		ContactLink.click();
	}
	
	public void SignOutFromApp() throws Throwable {
//		SignOutImg.click();
		Thread.sleep(2000);
		wlib.mousemoveOnElement(driver, SignOutImg);
		SignOutButton.click();
		
	}
}
