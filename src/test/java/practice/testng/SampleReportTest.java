package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.listenerutility.ListImpClass;

public class SampleReportTest extends ListImpClass {
	
	@Test
	public void createContactTest() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navihgate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFCdd".equals("HDFC")){
			test.log(Status.PASS,"contact is created");
		}else {
			test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
		}
		driver.close();
	}
	
	@Test
	public void createContactWithOrgTest() {
		ExtentTest test = report.createTest("createContactWithOrgTest");

		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navihgate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")){
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");
		}
		System.out.println("login to app");
	}
	
	@Test
	public void createContactWithPhoneNumberTest() {
		
		ExtentTest test = report.createTest("createContactWithPhoneNumberTest");

		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navihgate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")){
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");
		}
		System.out.println("login to app");
	}

}
