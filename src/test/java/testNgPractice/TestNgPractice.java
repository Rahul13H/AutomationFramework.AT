package testNgPractice;

import org.testng.annotations.Test;


public class TestNgPractice {
	
	/*
	//1st add TestNg Library than import test annotations
	@Test
	public void CreateContact() 
	{
		System.out.println("Contact Created");
	}
	public void ModifyContact() 
	{
		System.out.println("Contact Modified");
	}
	public void DeleteContact() 
	{
		System.out.println("Contact Deleted");
	}
	//Result:- passed:1, here execute only one method
	*/
	
	
	/*
	//Execute all methods but @Test written before every method
	@Test
	public void CreateContact() 
	{
		System.out.println("Contact Created");
	}
	@Test
	public void ModifyContact() 
	{
		System.out.println("Contact Modified");
	}
	@Test
	public void DeleteContact() 
	{
		System.out.println("Contact Deleted");
	}
	//Result:-passed:3, Execute all methods but @Test written before every method
	*/
	
	
	/*
	//@Test     <--using @Test before class name for execution all methods
	public class TestNgExample {
	
	public void CreateContact() 
	{
		System.out.println("Contact Created");
	}
	public void ModifyContact() 
	{
		System.out.println("Contact Modified");
	}
	public void DeleteContact() 
	{
		System.out.println("Contact Deleted");
	}
	}
	*/
	
	
	//Give priority order of execution own written script
	/*
	@Test(priority = 1)      //(priority = -3)
	public void CreateContact() 
	{
		System.out.println("Contact Created");
	}
	@Test(priority = 2)
	public void ModifyContact() 
	{
		System.out.println("Contact Modified");
	}
	@Test(priority = 3)  
	//@Test(enabled = false) //If don't want execute this
	//@Test(invocationCount = 3) //execution for more times - this method execute 3 time
	public void DeleteContact() 
	{
		System.out.println("Contact Deleted");
	}
	*/
	

	/*
	// invocation
	@Test(invocationCount = 2,priority = 1)
	public void CreateContact() 
	{
		System.out.println("create");
	}
	@Test
	public void ModifyContact() 
	{
		System.out.println("modify");
	}
	@Test
	public void DeleteContact() 
	{
		System.out.println("delete");
	}
	*/
	
	//use depends on method
		/*
		@Test
		public void CreateContact() 
		{
			enable = false
			System.out.println("Contact Created");
		}
		@Test(dependsOnMethods = "CreateContact")
		public void ModifyContact() 
		{
			System.out.println("Contact Modified");
		}
		@Test(dependsOnMethods = "CreateContact")
		public void DeleteContact() 
		{
			System.out.println("Contact Deleted");
		}
		*/
	
	
	/*
	//enables = boolean
	@Test(enabled = false)
	public void CreateContact() 
	{
		System.out.println("create");
	}
	@Test
	public void ModifyContact() 
	{
		System.out.println("modify");
	}
	@Test
	public void DeleteContact() 
	{
		System.out.println("delete");
	}
	*/
	
	
	
	
	
	
	

}
