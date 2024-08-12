package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void pageMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void pageMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForAlertPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForElementInvisibility(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForFrameAvailableAndSwitch(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public void switchToTabOnUrl(WebDriver driver, String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialUrl)) {
				break;
			}}
	}
	
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			
			String actUrl=driver.getTitle();
			if(actUrl.contains(partialTitle)) {
				break;
			}}
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void SwitchToAlertSendkeys(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
	public void SwitchToAlertGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	public Select dropdown(WebElement element) {
		Select sel=new Select(element);
		return sel;
	}
	
	public void select(WebElement element, String text) {
		dropdown(element).selectByVisibleText(text);
	}

	public void select(WebElement element, int index) {
		dropdown(element).selectByIndex(index);
	}
	
	public void select1(WebElement element, String value) {
		dropdown(element).selectByValue(value);
	}
	
	
	public Actions action(WebDriver driver) {
		Actions act=new Actions(driver);
		return act;
	}
	
	public void mousemoveOnElement(WebDriver driver,WebElement element) {
		action(driver).moveToElement(element).perform();
	
	}
	
	public void doubleClick(WebDriver driver,WebElement element) {
		action(driver).doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver,WebElement element) {
		action(driver).contextClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement element,WebElement element2) {
		action(driver).dragAndDrop(element,element2).perform();
	}

	public void clickAndHold(WebDriver driver,WebElement element) {
		action(driver).clickAndHold(element).perform();
	}
	
	public void release(WebDriver driver,WebElement element) {
		action(driver).release(element).perform();
	}

	public void scrollToElement(WebDriver driver,WebElement element) {
		action(driver).scrollToElement(element).perform();
	}

	public void scrollByAmount(WebDriver driver,int x , int y) {
		action(driver).scrollByAmount(x,y).perform();
	}
	
	public void scrollUntillEleToBeVisible(WebDriver driver,WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	int y=element.getLocation().getY();
		js.executeScript("window.ScrollBy(0,"+y+")");
//	js.executeScript("arguments[0].scrollIntoView()",element);
    }
	
	public void scrollUntillEleToBeClickable(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
	}
	
	public void TakesTakesScreenshot(WebDriver driver,String filename ) throws Throwable {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File desc = new File("./ScreenShots/Webelement.png");
	FileHandler.copy(src, desc);
	}
	
}
