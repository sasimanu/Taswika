package com.mart.vibe.api.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
  
public class DataBaseUtility {
	Connection conn =null;
	ResultSet result;
	public void getDbConnection(String url,String username,String password) throws Throwable {
		try {
		Driver driver =new Driver();
		DriverManager.registerDriver(driver);
	    conn = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
		}
		
	}
	public void getDbConnection() throws Throwable {
		FileUtility fLib =new FileUtility();
		try {
		Driver driver =new Driver();
		DriverManager.registerDriver(driver);
	    conn = DriverManager.getConnection(fLib.getDataFromPropertiesFile("DBUrl"),fLib.getDataFromPropertiesFile("DB_UserName"),fLib.getDataFromPropertiesFile("DB_Password"));
		}catch(Exception e) {
		}
		
	}
	
	
	public void closeDbConnection() throws SQLException {
		try {
			conn.close();
		}catch(Exception e) {
			
		}
		
	}
	
	public ResultSet ExecuteSelectQuery(String query) throws SQLException {
		 result=null;
		try {
		Statement stat = conn.createStatement();
		 result = stat.executeQuery(query);
		}catch(Exception e) {
		}
		return result;
	
	}
	
	
	public int excuteNonSelectQuery(String Query) throws SQLException {
		int result=0;
		try {
		Statement stat = conn.createStatement();
		result=stat.executeUpdate(Query);
		}catch(Exception e) {
		}
		
		return result;
		
	}
	
	public boolean executeQueryVerifyAndGetData(String query,int columnIndex,String expectedData) throws Throwable {
		boolean flag= false;
		result =conn.createStatement().executeQuery(query);
		while(result.next()) {
			if(result.getString(columnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		 if(flag==true) {
			 System.out.println(expectedData +"==>data verified in database");
			 return true;
		 }else {
			 System.out.println(expectedData +"==>data notverified in database");
			 return false;
		 }
		
		
	}
	

}
