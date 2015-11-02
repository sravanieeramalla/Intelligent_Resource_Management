package com.testview;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CloudDbConnection {
	public static void main(String args[]) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String dbURL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/ad_eba640075b9d58e";
		String username = "b5f00f11933f4b";
		String password = "f55ce5c6";
		Connection dbCon = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from resource_table";
		
		//String q4 = "update task_assignment set actualenddate='2015-11-03' where task_id=2 and r_id=5 ";
		String q4 = "update task_assignment set assignedhour=50 where task_id=2 and r_id=10";
		
		
		try {
			dbCon = DriverManager.getConnection(dbURL, username, password);
			stmt = dbCon.createStatement();
			System.out.println("Output : " + stmt.executeUpdate(q4));

		} catch (SQLException ex) {
			Logger.getLogger(Collections.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			try {
				stmt.close();
				dbCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
