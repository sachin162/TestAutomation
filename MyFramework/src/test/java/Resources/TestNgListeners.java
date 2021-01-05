package Resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestNgListeners extends BaseDriver implements ITestListener
{
	ExtentReports extent=ExtentReporterNG.getReporterObject();;
	ExtentTest test;
	WebDriver driver ;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		
		 test = extent.createTest(result.getMethod().getMethodName());
		
		String tcName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			//getScreenShot(tcName,driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
		
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
		String tcName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			getScreenShot(tcName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
