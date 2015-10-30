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
	
	public  List<Resource> getResourceByTaskId(int taskId){
		List<Resource> rlist=null;
				
		if(taskId!=0){		
		rlist=new ArrayList<Resource>();
			
		Resource r1= new Resource(10,"Deepak",4,"Open","12-10-2015","12-11-2015");
		Resource r2= new Resource(11,"Sravani",5,"Open","02-10-2015","29-11-2015");
		Resource r3= new Resource(12,"Madhuri",3,"Open","12-09-2015","12-12-2015");
		
		rlist.add(r1);
		rlist.add(r2);
		rlist.add(r3);
		}
		return rlist;
	}

	public Resource(int id, String name, int ratings, String status,
			String sdate, String edate) {
		super();
		this.id = id;
		this.name = name;
		this.ratings = ratings;
		this.status = status;
		this.sdate = sdate;
		this.edate = edate;
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
	
	
 

}
