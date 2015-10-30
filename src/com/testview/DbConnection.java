package com.testview;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.logging.Level; 
import java.util.logging.Logger;
 public class DbConnection{ 
	 public static void main(String args[]) throws ClassNotFoundException {
		 Class.forName("com.mysql.jdbc.Driver");
	 String dbURL = "jdbc:mysql://113.128.164.44:3306/intel";
	 String username ="Sravani"; 
	 String password = "Hack@123";
	 Connection dbCon = null; 
	 Statement stmt = null; 
	 ResultSet rs = null; 
	 String query ="select count(*) from resource_table";
	 try { 
		 //getting database connection to MySQL server
		 dbCon = DriverManager.getConnection(dbURL, username, password);
		 //getting PreparedStatment to execute query 
		 stmt = dbCon.prepareStatement(query); 
		//Result set returned by query 
		 rs = stmt.executeQuery(query);
		 while(rs.next()){
			 int count = rs.getInt(1);
			 System.out.println("count of stock : " + count); }
	 }catch (SQLException ex)
	 { Logger.getLogger(Collections.class.getName()).log(Level.SEVERE, null, ex); }
	 finally{ 
		 //close connection ,stmt and resultset here } } }
		 }
	 
 }
 }

