package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class Provides Implementation to ITestListener interface of testNG
 * @author RRRRRRRRRRRRR
 *
 */
public class ListenersImplementationClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" === test Script Execution Started ===");
		//create a test script - recognize each @Test
		test = report.createTest(testScriptName);
	}

	public void onTestSuccess(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" === Passed ===");
		//log the success
		test.log(Status.PASS, testScriptName+"== PASS ==");
	}

	public void onTestFailure(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" === Failed ===");
		
		//Execution for failure
		System.out.println(result.getThrowable());
		
		//log for failure
		test.log(Status.FAIL, testScriptName+"== FAIL ==");
		test.log(Status.INFO, result.getThrowable());
		
		//Screenshot
		String screenShotName = testScriptName+new JavaUtility().getSystemDate();
		WebDriverUtility w = new WebDriverUtility();
		try {
			  String Path = w.captureScreenShot(BaseClassExecution.sdriver, screenShotName);
			  test.addScreenCaptureFromPath(Path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" === Skipped ===");
		
		//Execution for failure
		System.out.println(result.getThrowable());
		
		//log for skip
		test.log(Status.SKIP,testScriptName+"== Skipped ==");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// This is new method :- its not used
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// This is new method :- its not used
	}

	public void onStart(ITestContext context) {
		System.out.println(" === Suite Execution Started ===");
		
		//Base Report configure
		ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("Vtiger Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Rahul");
	}

	public void onFinish(ITestContext context) {
		System.out.println(" === Suite Execution Finished ===");
		
		//Report Generation
		report.flush();
	}
	
	

}
