package com.testview;

public interface CNTPOOL {
	public static final String RESOURCE_BY_SKILL="select a.r_id,UCASE(a.r_skill),r.r_name,r.r_rating from resource_skill a left join resource_table r on a.r_id=r.r_id where a.r_skill=?";   
	
	public static final String RESOURCE_AVAILIBLITY_OCCUPIED="SELECT startdate,actualenddate,enddate FROM task_assignment WHERE R_ID=?";
	
	public static final String RESOURCE_BY_TASK_ID="select a.r_id,a.Task_status,a.startdate,a.enddate,a.actualenddate,a.assignedhour,r.r_name,r.r_rating from task_assignment a left join resource_table r on a.r_id=r.r_id where a.task_id=?";   
}
