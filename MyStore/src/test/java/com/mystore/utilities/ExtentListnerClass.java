package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListnerClass implements ITestListener
{
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReports()
	{
		ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd hh.mm.ss").format(new Date());
		String reportName = "MyStorev1TestReport - " + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
//		system information
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS:", "windows 11");
		reports.setSystemInfo("browser:", readConfig.getBrowser());
		reports.setSystemInfo("username:", "Dinesh");
		
//		look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my First Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
//	is called when any test starts
	public void onStart(ITestContext Result)
	{
		configureReports();
		System.out.println("on start method invoked....");
	}
	
//	is called after all tests are executed
	public void onFinish(ITestContext Result)
	{
		System.out.println("on finished method invoked....");
		reports.flush();
//		it is mandatory to call flush method to ensure information is written to the started reporter.
	}
	
//	when test case get failed, this method is called
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of the test method failed: " +Result.getName());
		test = reports.createTest(Result.getName()); //create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " +Result.getName(), ExtentColor.RED));
		
		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
		
		File screenShotFile = new File(screenShotPath);
		
		if(screenShotFile.exists())
		{
			test.fail("Captured screenshot is below: " +test.addScreenCaptureFromPath(screenShotPath));
		}
	}
	
//	when test case get skipped, this method is called
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of the test method skipped: " +Result.getName());
		test = reports.createTest(Result.getName()); //create entry in html report
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is: " +Result.getName(), ExtentColor.YELLOW));
	}
	
//	when test get started , this method is called
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of the test method started: " +Result.getName() );
	}
	
//	when test get passed, this method is called
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of the test method executed successfully: " + Result.getName() );
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
		
	}
}
