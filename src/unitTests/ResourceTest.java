package unitTests;
import org.junit.Test;

import com.testview.Resource;
import com.testview.TaskSkills;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ResourceTest {
	@Test
    public void testGetResourceByTaskIdZero() {
		try{
			Resource resourceObject = new Resource();
			List<Resource> rows=new ArrayList<Resource>();
			rows=resourceObject.getResourceByTaskId(0);
	        assertEquals(null, rows);
	        System.out.println("Test case testGetResourceByTaskIdZero Passed");
		}catch(AssertionError e){
			System.out.println("Test case testGetResourceByTaskIdZero Failed");
		}
		

    }
	@Test
    public void testGetResourceByTaskIdOfSizeTwo() {
		try{
			Resource resourceObject = new Resource();
			List<Resource> rows=new ArrayList<Resource>();
			rows=resourceObject.getResourceByTaskId(1);
	        assertEquals(2, rows.size());
	        System.out.println("Test case testGetResourceByTaskIdOfSizeTwo Passed");
		}catch(AssertionError e){
			System.out.println("Test case testGetResourceByTaskIdOfSizeTwo Failed");
		}
		

    }
	@Test
    public void testGetResourceByTaskIdOfSizeThree() {
		try{
			Resource resourceObject = new Resource();
			List<Resource> rows=new ArrayList<Resource>();
			rows=resourceObject.getResourceByTaskId(101);
	        assertEquals(3, rows.size());
	        
	        System.out.println("Test case testGetResourceByTaskIdOfSizeThree Passed");
		}catch(AssertionError e){
			System.out.println("Test case testGetResourceByTaskIdOfSizeThree Failed");
		}
		
    }
	@Test
	
	public void testgetResourceForTask(){
		
		//null,null,null,"test"
		try{
			Resource resourceObject = new Resource();
			List<Resource> rows=new ArrayList<Resource>();
			rows=resourceObject.getResourceForTask(null,0,null,"test");
	        assertEquals(null, rows);
	        
	        System.out.println("Test case testgetResourceForTask Passed");
		}catch(AssertionError e){
			System.out.println("Test case testgetResourceForTask Failed");
		}
		}
		
		@Test
		
		public void testgetResourceForTaskone(){
			
			
			try{
				Resource resourceObject = new Resource();
				List<Resource> rows=new ArrayList<Resource>();
				//List<TaskSkills> tasks=new ArrayList<TaskSkills>();
				
				rows=resourceObject.getResourceForTask("tasks",1,"01-11-2015","03-11-2015");
		        assertEquals(3, rows.size());
		        
		        System.out.println("Test case testgetResourceForTask Passed");
			}catch(AssertionError e){
				System.out.println("Test case testgetResourceForTask Failed");
			}
			
		
	}
	
	
	
	
}
