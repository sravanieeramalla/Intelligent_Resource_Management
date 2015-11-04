package com.testview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Resource {
	int objectCounter=0;
	
	int id=0;
	String name=null;
	int ratings=0;
	String status=null;
	String sdate=null;
	String edate=null;
	int occupiedpercentage=0;
	int availiblityStatus=0;
	int assignedhour=0;
	String aedate=null;
	String skills=null;
	boolean flag=false;

	public static void main(String[] args) {
		ArrayList<Resource> rows=getResourceBySkill("JAVA");
		for (Resource resource : rows) {
			System.out.println(resource);
		}
		
		
	}

	
	public static HashMap<String,String> getResourceAvailiblity(int r_id){
		
		String response=null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String start_date=null;
		String aend_date=null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal_today = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = null;
		
		int totalrecordcounter=0;
		
		HashMap<String,String> r_matrix = new HashMap<String, String>();	
		int number_of_opentask=0; //Need to calculate
		
		try {
			dbConnection = CloudDB.GetCONNECTION();
			preparedStatement = dbConnection.prepareStatement(CNTPOOL.RESOURCE_AVAILIBLITY_OCCUPIED);
			preparedStatement.setInt(1, r_id);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				
				start_date = rs.getString("startdate");
				if(rs.getString("actualenddate") == null ){
					number_of_opentask++;
					cal2=null;
				}else{
				++totalrecordcounter;//
				System.out.println("-->"+rs.getString("actualenddate"));
				cal1.setTime(sdf.parse(rs.getString("actualenddate")));
				System.out.println("-cal1->"+cal1.getTime());
				if(totalrecordcounter==1){
					cal2=cal1;
				}else{
					if(cal1.equals(cal2) || cal1.after(cal2)){
						cal2=cal1;
						System.out.println("Date1 is after Date2");
					}
				}
				}
			}	
			System.out.println("number_of_opentask : "+number_of_opentask);
			response=sdf.format(cal2.getTime());
		}catch(NullPointerException npe){
			response=null;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ParseException e) {
		e.printStackTrace();
		}	
		finally {
			try {
				rs.close();
				preparedStatement.close();
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		r_matrix.put("actualenddate", response);
		r_matrix.put("number_of_opentask", number_of_opentask+"");
		
		return r_matrix;

	}

	
	public static ArrayList<Resource> getResourceBySkill(String skill){
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		ArrayList<Resource> rows=new ArrayList<Resource>();
		
		try {
			dbConnection = CloudDB.GetCONNECTION();
			preparedStatement = dbConnection.prepareStatement(CNTPOOL.RESOURCE_BY_SKILL);
			preparedStatement.setString(1,skill.toUpperCase());
			rs = preparedStatement.executeQuery();
			
			//select a.r_id,a.r_skill,r.r_name,r.r_rating
			while (rs.next()) {
				Resource r = new Resource();
				r.setId(rs.getInt(1));
				r.setName(rs.getString(3));
				r.setSkills(rs.getString(2));
				r.setRatings(rs.getInt(4));
				//r.setEdate(rs.getString(5));
				rows.add(r);
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

	public static ArrayList<Resource> getResourceByTaskId(int taskId){
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		ArrayList<Resource> rows=new ArrayList<Resource>();
		
		try {
			dbConnection = CloudDB.GetCONNECTION();
			preparedStatement = dbConnection.prepareStatement(CNTPOOL.RESOURCE_BY_TASK_ID);
			preparedStatement.setInt(1, taskId);
			rs = preparedStatement.executeQuery();
			
			//select a.r_id,a.Task_status,a.startdate,a.enddate,a.actualenddate,a.assignedhour,r.r_name,r.r_rating
					
			while (rs.next()) {
				Resource r = new Resource();
				r.setId(rs.getInt(1));
				r.setStatus(rs.getString(2));
				r.setSdate(rs.getString(3));
				r.setEdate(rs.getString(4));
				r.setAedate(rs.getString(5));
				r.setAssignedhour(rs.getInt(6));
				r.setName(rs.getString(7));
				r.setRatings(rs.getInt(8));
				rows.add(r);
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
	
	//m2
	/*public  List<Resource> getResourceByTaskId(int taskId){
		List<Resource> rows=null;
				
		if(taskId!=0 ){		
			rows=new ArrayList<Resource>();
			
		Resource r1= new Resource(10,"Deepak",4,"Open","12-10-2015","12-11-2015",30,60,140,"12-11-2015");
		Resource r2= new Resource(11,"Sravani",5,"Open","02-10-2015","29-11-2015",50,50,120,"12-11-2015");
		Resource r3= new Resource(12,"Madhuri",3,"Open","12-09-2015","12-12-2015",80,20,100,"12-11-2015");
		
		rows.add(r1);
		rows.add(r2);
		if(taskId==101)
			rows.add(r3);
		}
		return rows;
	}*/

	
	//m3
	public  List<Resource> getResourceForTask(String skillset,int userId,String sdate,String edate){
		
		String skill = null;
		int hours = 0;
		int complexcity = 0;

		int i = 0;
		int temp = 0;

		ArrayList<Resource> rows =new ArrayList<Resource>();

		for (String retval : skillset.split(",")) {

			skill = null;
			hours = 0;
			complexcity = 0;
			i = 0;
			for (String rtl : retval.split(":")) {
				i++;
				if (i == 1)
					skill = rtl;
				if (i == 2)
					hours = Integer.parseInt(rtl);
				if (i == 3)
					complexcity = Integer.parseInt(rtl);
			}

			ArrayList<Resource> templist = getResourceBySkill(skill);
			
			if(templist.size()!=0){
				temp = hours / templist.size();
					for (Resource resource : templist) {
						if (resource.getRatings() == complexcity){
							resource.setFlag(true);}
							resource.setAssignedhour(temp);
							HashMap<String,String> amatrix= getResourceAvailiblity(resource.getId());
							
							
							
							
							
						rows.add(resource);
					}
			}
		}
		return rows;
	}

	public Resource() {
		objectCounter++;
	}

	public Resource(int id, String name, int ratings, String status,
			String sdate, String edate, int occupiedpercentage,
			int availiblityStatus, int assignedhour, String aedate) {
		super();
		this.id = id;
		this.name = name;
		this.ratings = ratings;
		this.status = status;
		this.sdate = sdate;
		this.edate = edate;
		this.occupiedpercentage = occupiedpercentage;
		this.availiblityStatus = availiblityStatus;
		this.assignedhour = assignedhour;
		this.aedate = aedate;
	}

	@Override
	public String toString() {
		String str="";
		if(!(objectCounter>1)){
		str="id\t"+
				"name\t"+
				"ratings\t"+
				"assignedhour\t"+
				"occupiedpercentage\t"+
				"skills\t"+
				"edate\t"+
				"flag\n";}
		str+=id+"\t"+
				name+"\t"+
				ratings+"\t"+
				assignedhour+"\t"+
				occupiedpercentage+"\t"+
				skills+"\t"+
				edate+"\t"+
				flag+"\n";
		return str;
	}

	public boolean isFlag() {
		return flag;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
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

	public int getOccupiedpercentage() {
		return occupiedpercentage;
	}

	public void setOccupiedpercentage(int occupiedpercentage) {
		this.occupiedpercentage = occupiedpercentage;
	}

	public int getAvailiblityStatus() {
		return availiblityStatus;
	}

	public void setAvailiblityStatus(int availiblityStatus) {
		this.availiblityStatus = availiblityStatus;
	}

	public int getAssignedhour() {
		return assignedhour;
	}

	public void setAssignedhour(int assignedhour) {
		this.assignedhour = assignedhour;
	}

	public String getAedate() {
		return aedate;
	}

	public void setAedate(String aedate) {
		this.aedate = aedate;
	}

	

	
}
