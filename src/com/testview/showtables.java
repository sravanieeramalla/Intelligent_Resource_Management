package com.testview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class showtables {
	public static void main(String args[]) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String dbURL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/ad_eba640075b9d58e";
		String username = "b5f00f11933f4b";
		String password = "f55ce5c6";

		Connection dbCon = null;
		Statement stmt = null;
		ResultSet rs = null;
		String tq = "select * from Task_details";
		String rq = "select * from resource_table";
		String taq = "select * from task_assignment ";
		String dq ="SELECT DISTINCT TASK_STATUS FROM task_assignment WHERE TASK_ID=2";
		try {
			dbCon = DriverManager.getConnection(dbURL, username, password);
			
			
			stmt = dbCon.createStatement();
		   //Query
			rs = stmt.executeQuery(taq);

		    ResultSetMetaData metadata = rs.getMetaData();
		    int columnCount = metadata.getColumnCount();

		    ArrayList<String> columns = new ArrayList<String>();
		    for (int i = 1; i <=columnCount; i++) {
		      String columnName = metadata.getColumnName(i);
		      columns.add(columnName);
		    }
		    
		    
			      for (String columnName : columns) {
			        System.out.print(columnName + "\t");
			      }
			    
		System.out.println("");
		   while (rs.next()) {
		      for (String columnName : columns) {
		        String value = rs.getString(columnName);
		        System.out.print(value + "\t");
		      }
		      System.out.println("");
		    }
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {

				stmt.close();
				rs.close();
				dbCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
