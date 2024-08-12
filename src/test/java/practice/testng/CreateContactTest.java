package practice.testng;

import org.testng.annotations.Test;

public class CreateContactTest {
	
	@Test
	public void createContactTest() {
		System.out.println("execute test");
		System.out.println("execute navigate to contact");
		System.out.println("execute create contact");
		System.out.println("execute verify contact");
		System.out.println("execute logout");
	}
	
	@Test
	private void createContactWithMobileNumTest() {
		System.out.println("execute createContactWithMobileNumTest");
	}

}
