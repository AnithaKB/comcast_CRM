package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
	
	@FindBy(xpath = "//img[@alt=\"Create Product...\"]")
	private WebElement createProductImgBtn;
	

	@FindBy(name="searchBtn")
	private WebElement ele3;

	@FindBy(name="search")
	private WebElement ele1;

	

}
