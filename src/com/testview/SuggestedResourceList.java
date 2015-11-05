package com.testview;

import java.util.ArrayList;

public class SuggestedResourceList {

	String dh = "Prasad Pusarla";
	String spm = "Bhupesh";
	String manager = "Sundeep Paderu";
	ArrayList<Resource> rows = null;

	public SuggestedResourceList() {
	}

	public SuggestedResourceList(ArrayList<Resource> rows) {
		super();
		this.rows = rows;
	}

	public String getDh() {
		return dh;
	}

	
	public String getSpm() {
		return spm;
	}

		public String getManager() {
		return manager;
	}

	
	public ArrayList<Resource> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Resource> rows) {
		this.rows = rows;
	}

}
