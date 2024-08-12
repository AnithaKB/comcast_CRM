package practice.testng;

import org.testng.annotations.DataProvider;

public class Execute {
	
	@DataProvider
	public Object[][] Order()
	{
		Object[][] objArr=new Object [3][2];
		objArr[0][0] ="deepak";
		objArr[0][1] ="hr";
		objArr[1][0] ="sam";
		objArr[1][1] ="sh";
		objArr[2][0] ="Jhon";
		objArr[2][1] ="smith";
		return objArr;
		
	}
	@DataProvider
	public Object[][] Product()
	{
		Object[][] objArr=new Object [2][2];
		objArr[0][0] ="deepak";
		objArr[0][1] ="hr";
		objArr[1][0] ="sam";
		objArr[1][1] ="sh";
		return objArr;
		
	}

}
