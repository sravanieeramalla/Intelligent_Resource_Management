package com.testview;

public class TaskSkills {

	String skill=null;
	int numberofhour=0;
	int cplxlevel=0;

	public TaskSkills() {
	}

	public TaskSkills(String skill, int numberofhour, int cplxlevel) {
		super();
		this.skill = skill;
		this.numberofhour = numberofhour;
		this.cplxlevel = cplxlevel;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getNumberofhour() {
		return numberofhour;
	}

	public void setNumberofhour(int numberofhour) {
		this.numberofhour = numberofhour;
	}

	public int getCplxlevel() {
		return cplxlevel;
	}

	public void setCplxlevel(int cplxlevel) {
		this.cplxlevel = cplxlevel;
	}

}
