package practice.testng;

import org.testng.annotations.Test;

public class Demo {
	@Test(dataProviderClass = Execute.class, dataProvider = "Product")
	public void createContactTest(String firstName , String lastName) {
		System.out.println("FirstName:"+firstName+",Lastname:"+lastName);
	}

}
