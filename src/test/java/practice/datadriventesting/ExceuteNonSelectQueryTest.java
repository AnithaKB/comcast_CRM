package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExceuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		//step 1: load/register the database driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//step 2: connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/qspider","root","root");
		System.out.println("======Done======");
		
		//step 3: create sql statement
		Statement state = con.createStatement();
		
		//step 4: execute select query & get result
		int res = state.executeUpdate(" insert into student values('05','Ram1','6534776');");
		System.out.println(res);
		
		//step 5: close the connection
		con.close();
		


	}

}
