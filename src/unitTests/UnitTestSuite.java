package unitTests;

public class UnitTestSuite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceTest rt=new ResourceTest();
		rt.testGetResourceByTaskIdOfSizeThree();
		rt.testGetResourceByTaskIdOfSizeTwo();
		rt.testGetResourceByTaskIdZero();
		rt.testgetResourceForTask();
		rt.testgetResourceForTaskone();
		
		TaskTest tt=new TaskTest();
		
		tt.testgetTaskList();
		
	}

}
