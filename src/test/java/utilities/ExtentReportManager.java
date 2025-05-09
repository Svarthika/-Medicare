package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTestCase.BaseTestClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	String repName;
	
	public void onStart(ITestContext testcontext){
		SimpleDateFormat df = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss");
		Date dt = new Date();
		String Currentdatetimestamp = df.format(dt);
		
		String TimeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		repName = "Test-Report"+TimeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+ repName); //specify location of reports and format
		//configure UI of report
		sparkReporter.config().setDocumentTitle("Atomation");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		// Common info for reports
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Medicare");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub module", "Customer");
		extent.setSystemInfo("User name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
		
		String os = testcontext.getCurrentXmlTest().getParameter("Os");
		extent.setSystemInfo("Operating System", "os");
		
		String br = testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", "br");
		
		List<String> includedGroups = testcontext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("includedGroups", includedGroups.toString());
		}
		
	}
	
 public void onTestSuccess(ITestResult result) {
	
	 test = extent.createTest(result.getTestClass().getName());
	 test.assignCategory(result.getMethod().getGroups());
	 test.log(Status.PASS, result.getName()+" got successfully executed");	
		
		
	}
	
 
 public void onTestFailure(ITestResult result) {
	 test=extent.createTest(result.getTestClass().getName());//from result get the class name and create entry in report
	 test.assignCategory(result.getMethod().getGroups());//from reesult it gets method name executed from group
	 
	 test.log(Status.FAIL, result.getName()+" got Failed");
	 test.log(Status.INFO, result.getThrowable().getMessage());
	 
	 try {
		 String imgPath = new BaseTestClass().captureScreen(result.getName());// base class + method returns string
		 test.addScreenCaptureFromPath(imgPath);
		  }
	 
	 catch(Exception e) {
		 e.printStackTrace();
	 }
 }
	 public void onTestSkipped(ITestResult result)
	 {
		 test = extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.SKIP , result.getName()+"got Skipped");
		 test.log(Status.INFO, result.getThrowable().getMessage());
		 
	 }
	 
	 public void onFinish(ITestContext context) {
		 
		
			    if (extent != null) {
			        extent.flush();
			    } else {
			        System.out.println("ExtentReports is null, cannot flush.");
			    }
			
	  String PathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		 File extentReport = new File(PathOfExtentReport);
		 
		 try {
			 Desktop.getDesktop().browse(extentReport.toURI());
		 }
		 catch(IOException e) {
			 e.printStackTrace();
		 }
		 
	 }
 }
 
 

