package unitTests;

import java.util.ArrayList;
import java.util.List;

import com.testview.Resource;
import com.testview.Task;
import com.testview.TaskSkills;

public class FirstTest {
	
	
	public static void main(String[] args){
		
		Task tsk = new Task();
		Resource rsrc = new Resource();
		List<Task> lstTask = tsk.getTaskList();
		
		
		//getting resource using taskId
		int intTaskId = lstTask.get(0).getId();
		System.out.println("The task Id is "+intTaskId);
		List<Resource>lstRsrc = rsrc.getResourceByTaskId(lstTask.get(0).getId());
		System.out.println("The number of resources available for the given task id:"+intTaskId+" are "+lstRsrc.size());
		
		//getting resource for skills
		TaskSkills tskSkil = new TaskSkills("java", 20, 2);
		List<TaskSkills> lstTskSkls = new ArrayList<TaskSkills>();
		lstTskSkls.add(tskSkil);
		List<Resource>lstRsrc1 = rsrc.getResourceForTask(1, lstTskSkls, "15-10-2015","22-12-2016");
		System.out.println("The number of resources available for the given task id:"+intTaskId+" are "+lstRsrc1.size());
		//"15-10-2015","22-10-2015"
		
	}

}
