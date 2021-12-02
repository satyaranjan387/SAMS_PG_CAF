package com.PG.Listener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	
	static ExtentReports report;
	
	public static ExtentReports setupExtentReport() {
		
		SimpleDateFormat format= new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		String actualDate=format.format(date);
		
		String reportPath = System.getProperty("user.dir")+
				"/Reports/PGExtentReport.html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

		report = new ExtentReports();
		report.attachReporter(sparkReport);

		//for adding logo
		sparkReport.loadXMLConfig(new File(System.getProperty("user.dir")+"\\logoconfig.xml"));
		
		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.loadXMLConfig("D:\\SamsPG\\logoconfig.xml");
		//sparkReport.config().setReportName("Extent Report");
		
//		report.setSystemInfo("Executed on Environment:",System.getProperty(constants.url));
//		report.setSystemInfo("Executed on Browser:", System.getProperty(constants.browser));
		report.setSystemInfo("Executed on OS:", System.getProperty("os.name"));
		report.setSystemInfo("Executed by User:", System.getProperty("user.name"));
		
		return report;
		
	}

}
