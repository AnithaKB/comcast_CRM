package mock1;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookHotel {

	public static void main(String[] args) throws Throwable {
	
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://in.via.com/");
		
		driver.findElement(By.id("loginIdText")).sendKeys("anithabaskar29@gmail.com");
		driver.findElement(By.id("passwordText")).sendKeys("Skyisblue25*");
		driver.findElement(By.xpath("//input[@value=\"Sign In\"]")).click();
		
		
		driver.findElement(By.xpath("//span[text()='Hotels ']")).click();
		WebElement dest = driver.findElement(By.xpath("//input[@name=\"destination\"]"));
		
//		dest.sendKeys("Bangalore",Keys.ARROW_DOWN);
		dest.sendKeys("Bangalore",Keys.ARROW_DOWN);  //stale element exception
		
		Thread.sleep(2000);
//		WebElement loc = driver.findElement(By.xpath("//input[@id=\"checkIn\"]"));
//		System.out.println(loc.getLocation().getX());
//		System.out.println(loc.getLocation().getY());
		Actions act=new Actions(driver);
		act.getActivePointer().createPointerMove(Duration.ofSeconds(5), null, 147, 308);
		act.keyDown("Bangalore,Karnataka,India").click().perform();
//		act.moveByOffset(147, 308).click().perform();
		
		driver.findElement(By.xpath("//div[@class=\"search-hotel u_vertAlignMiddle u_floatR\"]")).click();
		
//		driver.findElement(By.xpath("//p[text()='The Chancery Pavilion']")).click();
		
		
//		WebElement image = driver.findElement(By.xpath("//span[text()='Holidays ']"));
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File src = image.getScreenshotAs(OutputType.FILE);
//		File desc = new File("./Screenshot/img.png");
//		FileUtils.copyFile(src, desc);
		
		

	}


}
