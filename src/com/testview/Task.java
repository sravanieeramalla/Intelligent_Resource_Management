package com.testview;

import java.util.ArrayList;
import java.util.List;

public class Task {
	
	int id=0;
	String title=null;
	String status=null;
	String sdate=null;
	String edate=null;
	String aedate=null;
	List<String> skills=null;
	int clevel=0;
	String desc=null;
	
	
	
	//m1
	public List<Task> getTaskList(){
		
		ArrayList<String> skills=new ArrayList<String>();
		skills.add("Java");
		skills.add("DB");
		
		ArrayList<Task> rows=new ArrayList<Task>();
		Task t1 = new Task(101,"PACE","Completed","12-03-2013","12-07-2014","15-08-2014",skills,4,"Time reporting Apps");
		Task t2 = new Task(102,"VzTime","Completed","11-05-2013","10-10-2014","15-10-2014",skills,5,"New time reporting for all");		
		
		rows.add(t1);
		rows.add(t2);
		return rows;
	}
	
	public Task() {
	}

	
	
	public Task(int id, String title, String status, String sdate,
			String edate, String aedate, List<String> skills, int clevel,
			String desc) {
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

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
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
}


