package org.example.ecommerceframework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports generateExtentReport() {
		
	
	String path = System.getProperty("user.dir")+"//Reports//index.html";
	ExtentSparkReporter report = new ExtentSparkReporter(path);
	report.config().setReportName("Web Automation Report");
	report.config().setDocumentTitle("Test Report");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(report);
	extent.setSystemInfo("Tester", "Ummul Fasla");
	return extent;

}
}