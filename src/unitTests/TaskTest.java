package unitTests;
import org.junit.Test;
import com.testview.Task;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;


public class TaskTest {

	@Test
	
	public void testgetTaskList(){
		try{
		Task t=new Task();
		
		List<Task> tasks=new ArrayList<Task>();
		tasks=t.getTaskList();		
		assertEquals(2, tasks.size());
		System.out.println("Test case testgetTaskList Passed");
		}catch(AssertionError e){
			System.out.println("Test case testgetTaskList Failed");
		}
		
		
		
		
		
	}

}
