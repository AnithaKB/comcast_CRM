package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjInBackEnd {

    @Test
	public void projectCheckTest() throws SQLException {
		String ExpectedName="Name";
		boolean flag=false;
		
		//step 1: load/register the database driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//step 2: connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/qspider","root","root");
		System.out.println("======Done======");
		
		//step 3: create sql statement
		Statement state = con.createStatement();
		
		//step 4: execute select query & get result
		ResultSet res = state.executeQuery("select * from student");
		while(res.next()) {
			String actName=res.getString(2);
			if(ExpectedName.equals(actName)) {
				flag=true;
			System.out.println(ExpectedName+" is available==PASS");
		}
			}
		
		if(flag==false) {
			System.out.println(ExpectedName+" is not available==FAIL");
			Assert.fail();
		}
		
		//step 5: close the connection
		con.close();
		

	}

}
