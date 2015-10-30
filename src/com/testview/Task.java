package com.testview;

import java.util.ArrayList;
import java.util.List;

public class Task {
	
	int id=0;
	String Title=null;
	String status=null;
	String sdate=null;
	String edate=null;
	String aedate=null;
	List<String> skills=null;
	int cmpxlevel=0;
	
	
	//m1
	public List<Task> getTaskList(){
		
		ArrayList<String> skills=new ArrayList<String>();
		skills.add("Java");
		skills.add("DB");
		
		ArrayList<Task> tlist=new ArrayList<Task>();
		Task t1 = new Task(101,"PACE","Completed","12-03-2013","12-07-2014","15-08-2014",skills,4);
		Task t2 = new Task(102,"VzTime","Completed","11-05-2013","10-10-2014","15-10-2014",skills,5);		
		
		tlist.add(t1);
		tlist.add(t2);
		return tlist;
	}
	
	public Task() {
	}

	public Task(int id, String title, String status, String sdate,
			String edate, String aedate, List<String> skills, int cmpxlevel) {
		super();
		this.id = id;
		Title = title;
		this.status = status;
		this.sdate = sdate;
		this.edate = edate;
		this.aedate = aedate;
		this.skills = skills;
		this.cmpxlevel = cmpxlevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
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

	public int getCmpxlevel() {
		return cmpxlevel;
	}

	public void setCmpxlevel(int cmpxlevel) {
		this.cmpxlevel = cmpxlevel;
	}

}

