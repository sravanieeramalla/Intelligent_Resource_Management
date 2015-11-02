package com.testview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CloudDB {
	public static Connection GetCONNECTION(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String dbURL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/ad_eba640075b9d58e";
		final String username = "b5f00f11933f4b";
		final String password = "f55ce5c6";
		Connection dbCon=null;
		try {
			dbCon= DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbCon;
		
	}
}
