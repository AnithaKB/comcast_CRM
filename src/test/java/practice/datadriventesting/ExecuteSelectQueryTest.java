package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		
		try {
		//step 1: load/register the database driver
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				
				//step 2: connect to database
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3307/qspider","root","root");
				System.out.println("======Done======");
				
				//step 3: create sql statement
				Statement state = con.createStatement();
				
				//step 4: execute select query & get result
				ResultSet res = state.executeQuery("select * from student1");
				while(res.next()) {
					System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t");
				}}catch (Exception e) {
					System.out.println("handle exception");
				}finally {
					//step 5: close the connection
					con.close();
					System.out.println("==========close the connection=======");
				}
				

	}

}
