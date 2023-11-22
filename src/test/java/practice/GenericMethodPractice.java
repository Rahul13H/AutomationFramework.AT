package practice;

public class GenericMethodPractice {

	public static void main(String[] args) {  //caller
		
		int sum=add(600,500);
		System.out.println(sum);
	}
	
	public static int add(int a, int b)   //called
	{
		int c=a+b;
		return c;
	}
	
}
