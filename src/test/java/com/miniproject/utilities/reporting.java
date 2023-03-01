package com.miniproject.utilities;

//listner class to generate extentareport
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String repName = "test-Report-" + timestamp + ".html";// report name filename
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);// specify
																											// locatoion
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Mahesh");

		htmlReporter.config().setDocumentTitle("miniproject");// name of the report.
		htmlReporter.config().setReportName("Functional test report");// location of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);// location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSucccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());// create new entry in the report.
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));// send the passed info
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";
		File f = new File(screenshotPath);
		if (f.exists()) {
			try {
				logger.fail("screenshot is below" + logger.addScreenCaptureFromPath(screenshotPath, screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());// create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		// logger.log(Status.SKIP,MarkupHelper.createlabel(tr.getName(),
		// ExtentColor.ORANGE));

	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
