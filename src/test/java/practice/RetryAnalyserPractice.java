package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void analyserPractice()
	{
		//Assert.fail();  // if script fail--> than its run more than one time, if pass its run only 1 time 
		System.out.println("Hi");
	}

}
