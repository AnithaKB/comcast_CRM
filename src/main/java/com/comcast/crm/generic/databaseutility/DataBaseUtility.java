package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	
	public void getDbconnection(String url,String username, String password ) {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			con=DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
		}
	}
	

	public void getDbconnection() {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/qspider","root","root");
		}catch(Exception e) {
		}
	}
	
	public void closeDbconnection( ) throws SQLException {
		try {
			con.close();
		}catch (Exception e) {
		}
	}
	
	public ResultSet executeSelectQuery(String query) throws Throwable {
		ResultSet result=null;
		try {
		Statement state = con.createStatement();
        result = state.executeQuery(query);
		}catch(Exception e) { 
		}
		return result;
	}
	
	public int executeNonselectQuery(String query) {
		int result=0;
		try {
			Statement state=con.createStatement();
			state.executeUpdate(query);
		}catch(Exception e) {
			
		}
		return result;
	}
}
