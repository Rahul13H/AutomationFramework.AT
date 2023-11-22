package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide implementation to the IRetryAnalyser interface of TestNG
 * @author RRRRRRRRRRRRR
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int Count = 0;
	int retryCount = 3;  // its written only before checking manually script run which time test retry failed and after pass
	
	public boolean retry(ITestResult result) {
		//0<3 1<3 2<3 3<3No
		while(Count<retryCount)
		{
		  Count++;  //1  2   3
		  return true;  //retry  retry  retry
		}
		return false;  //stop retrying
	}
	

}
