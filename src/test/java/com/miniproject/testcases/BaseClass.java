package com.miniproject.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.miniproject.utilities.ReadConfig;

public class BaseClass {
	ReadConfig read = new ReadConfig();
	// earlier
	// public String baseURL = "https://demo.guru99.com/v4/";
	// public String username = "mngr473590";
	// public String password = "upYtEdy";
	// public String chromepath= "./Drivers/chromedriver.exe";
	// public String firefoxpath = "./Drivers/geckodriver.exe";

	public String baseURL = read.getApplicationURL();
	public String username = read.getusername();
	public String password = read.getpassword();
	public String chromepath = read.getchromepath();
	public String firefoxpath = read.getfirefoxpath();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	// gets br from xml
	public void setUP(String br) {

		logger = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("log4j2.properties");

		// condition
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", read.getchromepath());
			// WebDriverManager.chromedriver().setUp(;)
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\miniproject\\Drivers\\firefoxdriver.exe");
			// WebDriverManager.chromedriver().setUp(;)
			System.setProperty("webdriver.gecko.driver", read.getfirefoxpath());

			driver = new FirefoxDriver();
		}
		driver.get(baseURL);
		logger.info("url is opened");

	}

	public void capturescreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken..");

	}

	public String RandomString() {
		String RandomString = RandomStringUtils.randomAlphabetic(8);
		return (RandomString);
	}

	public String RandomNum() {
		String generatedstring = RandomStringUtils.randomNumeric(8);
		return generatedstring;
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
		driver.close();
	}

}
