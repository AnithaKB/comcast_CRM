package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;


public class ActivateSimTest extends BaseClass {
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSim() {
		System.out.println("execute createInvoiceTest");
//		Assert.assertEquals("", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
}
