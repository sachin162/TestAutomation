package Resources;


import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG
{
	static ExtentReports extent;
	@BeforeTest
	static public ExtentReports getReporterObject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Sachin Kulkarni Automation reports");
		reporter.config().setDocumentTitle("SachinQA Test Results");
		
		 extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test Engineer	", "Sachin Kulkarni");
		return extent;
		
	}

}
