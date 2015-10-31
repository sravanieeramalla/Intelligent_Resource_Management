package com.testview;

import java.util.ArrayList;
import java.util.List;

public class Resource {
	
	int id=0;
	String name=null;
	int ratings=0;
	String status=null;
	String sdate=null;
	String edate=null;
	int occupiedpercentage=0;
	int availiblityStatus=0;
	
	//m2
	public  List<Resource> getResourceByTaskId(int taskId){
		List<Resource> rows=null;
				
		if(taskId!=0 ){		
			rows=new ArrayList<Resource>();
			
		Resource r1= new Resource(10,"Deepak",4,"Open","12-10-2015","12-11-2015",30,60);
		Resource r2= new Resource(11,"Sravani",5,"Open","02-10-2015","29-11-2015",50,50);
		Resource r3= new Resource(12,"Madhuri",3,"Open","12-09-2015","12-12-2015",80,20);
		
		rows.add(r1);
		rows.add(r2);
		if(taskId==101)
			rows.add(r3);
		}
		return rows;
	}

	//m3
	public  List<Resource> getResourceForTask(int userId,List<TaskSkills> taskSkill,String sdate,String edate){
		List<Resource> rows=null;
				
		if(userId!=0 && taskSkill!=null &&  sdate!=null && edate!=null){		
			rows=new ArrayList<Resource>();
			
		Resource r1= new Resource(10,"Deepak",4,"Open","12-10-2015","12-11-2015",30,60);
		Resource r2= new Resource(11,"Sravani",5,"Open","02-10-2015","29-11-2015",50,50);
		Resource r3= new Resource(12,"Madhuri",3,"Open","12-09-2015","12-12-2015",80,20);
		
		rows.add(r1);
		rows.add(r2);
		rows.add(r3);
		}
		return rows;
	}

	
	public Resource() {
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

	public Resource(int id, String name, int ratings, String status,
			String sdate, String edate, int occupiedpercentage,
			int availiblityStatus) {
		super();
		this.id = id;
		this.name = name;
		this.ratings = ratings;
		this.status = status;
		this.sdate = sdate;
		this.edate = edate;
		this.occupiedpercentage = occupiedpercentage;
		this.availiblityStatus = availiblityStatus;
	}


	
}
