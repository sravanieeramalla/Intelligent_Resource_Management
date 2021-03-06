package com.testview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Task {
	
	int id=0;
	String title=null;
	String status=null;
	String sdate=null;
	String edate=null;
	String aedate=null;
	String skills=null;
	int clevel=0;	
	String desc=null;
	
	
	
	public List<Task> getTaskList(){
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String selectSQL ="SELECT * FROM Task_details";
		ArrayList<Task> rows=new ArrayList<Task>();
		String task_status=null;
		try {
			dbConnection = CloudDB.GetCONNECTION();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			rs = preparedStatement.executeQuery();
			
			//Task_ID	Task_Name	Task_Description	Task_StartDate	
			//Task_EndDate	Task_RequiredSkills	Task_ComplexityLevel
					
			while (rs.next()) {
				Task t1 = new Task();
				t1.setId(rs.getInt(1));
				t1.setTitle(rs.getString(2));
				t1.setDesc(rs.getString(3));
				t1.setSdate(rs.getString(4));
				t1.setEdate(rs.getString(5));
				t1.setSkills(rs.getString(6));
				t1.setClevel(rs.getInt(7));
				task_status=getTaskStatus(rs.getInt(1));
				t1.setStatus(task_status);
				if(task_status.equalsIgnoreCase("Completed")){
					t1.setAedate(getTaskActualEndDate(rs.getInt(1)));
				}else{
					t1.setAedate(null);
				}
				rows.add(t1);
			}
			 
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				preparedStatement.close();
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rows;

	}
	
	
public static String getTaskStatus(int task_id){
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String task_status=null;
		String selectSQL ="SELECT DISTINCT TASK_STATUS FROM task_assignment WHERE TASK_ID=?";
		try {
			dbConnection = CloudDB.GetCONNECTION();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, task_id);
			rs = preparedStatement.executeQuery();
			int count=0;
			while (rs.next()) {
				count++;
				task_status = rs.getString("TASK_STATUS");
			}
			
			if(count==1){
			}else{
				task_status="In Progress";
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				preparedStatement.close();
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return task_status;

	}



	
public static String getTaskActualEndDate(int task_id){
	
	Connection dbConnection = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	String task_aenddate=null;
	String selectSQL ="SELECT MAX(actualenddate) FROM task_assignment WHERE TASK_ID=?";
	try {
		dbConnection = CloudDB.GetCONNECTION();
		preparedStatement = dbConnection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, task_id);
		rs = preparedStatement.executeQuery();
		while (rs.next()) {
			task_aenddate = rs.getDate(1)+"";
		}
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		try {
			rs.close();
			preparedStatement.close();
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return task_aenddate;

}
	
	
	
	
	
	
	//m1
	/*public List<Task> getTaskList(){
		
		ArrayList<Task> rows=new ArrayList<Task>();
		Task t1 = new Task(101,"PACE","Completed","12-03-2013","12-07-2014","15-08-2014","java,DB",4,"Time reporting Apps");
		Task t2 = new Task(102,"VzTime","Completed","11-05-2013","10-10-2014","15-10-2014","OBIEE,ODI",5,"New time reporting for all");		
		
		rows.add(t1);
		rows.add(t2);
		return rows;
	}
*/	
	public Task() {
	}

	
	
	

	public Task(int id, String title, String status, String sdate,
			String edate, String aedate, String skills, int clevel, String desc) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.sdate = sdate;
		this.edate = edate;
		this.aedate = aedate;
		this.skills = skills;
		this.clevel = clevel;
		this.desc = desc;
	}

	@Override
	public String toString() {
		
		String str=id+"\t"+
				title+"\t"+
				status+"\t"+
				edate+"\t"+
				aedate+"\t"+
				skills+"\t"+
				clevel+"\t"+
				desc+"\n";
		return str;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getAedate() {
		return aedate;
	}

	public void setAedate(String aedate) {
		this.aedate = aedate;
	}

	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getClevel() {
		return clevel;
	}
	
	public void setClevel(int clevel) {
		this.clevel = clevel;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}

	public static void main(String[] args) {
		System.out.println("New id :"+getNewTaskId());
	}

	public static int getNewTaskId() {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int  new_id=0;
		String selectSQL ="SELECT max(task_id) FROM Task_details";
		try {
			dbConnection = CloudDB.GetCONNECTION();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				new_id = rs.getInt(1);
			}
			new_id++;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				preparedStatement.close();
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new_id;
	}

	public static int save(String title2, String sdate2, String edate2,
			String description, String clevel2) {
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int  new_id=getNewTaskId();
		String selectSQL ="insert into Task_details values(?,?,?,?,?,?,?)";
		try {
			dbConnection = CloudDB.GetCONNECTION();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, new_id);
			preparedStatement.setString(2, title2);
			preparedStatement.setString(3, description);
			preparedStatement.setString(4, sdate2);
			preparedStatement.setString(5, edate2);
			preparedStatement.setString(6, null);
			preparedStatement.setInt(7, Integer.parseInt(clevel2));
			preparedStatement.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new_id;

	}

	
}


