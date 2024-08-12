package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	
	@Test
	public void createContactTest() {
		System.out.println("execute createContact with -->HDFC");
		
	}
	
	@Test(dependsOnMethods = "createContactTest")
	private void modifycontactTest() {
		
		System.out.println("execute modifycontactTest-->HDFC=>ICICI");
	}

	@Test(dependsOnMethods = "modifycontactTest")
	private void deletecontactTest() {
		
		System.out.println("execute deletecontactTest-->ICICI");
	}
}
