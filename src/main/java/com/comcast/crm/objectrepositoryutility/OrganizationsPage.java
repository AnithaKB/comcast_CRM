package com.comcast.crm.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Organization...\"]")
	private WebElement clickOrgBtn;
	
	@FindBy(xpath = "//table[@class=\"lvt small\"]/tbody/tr/td[3]")
	private List<WebElement> orgList;
	
	@FindBy(xpath = "//input[@class=\"txtBox\"]")
	private WebElement searchOrgBtn;
	
	@FindBy(xpath = "//select[@id=\"bas_searchfield\"]")
	private WebElement searchDD;

	@FindBy(xpath = "//input[@name=\"submit\"]")
	private WebElement searchBtn;
	
	public WebElement getClickOrgBtn() {
		return clickOrgBtn;
	}
	
	public WebElement getSearchOrgBtn() {
		return searchOrgBtn;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void ClickOrgPlusSign() {
	clickOrgBtn.click();
	}

	public List<WebElement> getOrgList() {
		return orgList;
	}
	
    //Business Logic
	public void getOrgListInConsole() {
		for(WebElement name:orgList ) {
			String orgNames=name.getText();
			System.out.println(orgNames);
		}
		
	}
	
	
}
