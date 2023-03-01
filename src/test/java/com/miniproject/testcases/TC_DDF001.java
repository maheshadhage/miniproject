package com.miniproject.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.miniproject.pageobjects.LoginPage;
import com.miniproject.utilities.XLUtils;

public class TC_DDF001 extends BaseClass {
	@Test(dataProvider = "LoginData")
	public void loginddt(String user, String pwd) {
		LoginPage lp = new LoginPage(driver);
		lp.SetUsername(username);
		logger.info("username provide");
		lp.SetPassword(password);
		logger.info("password provide");
		lp.Clicksubmit();
		logger.info("clicked on submit");

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		} else {
			Assert.assertTrue(true);
			logger.info("login successful");
			lp.Clicklogout();
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();

		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/miniproject/testdata/Book1forddf.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String Logindata[][] = new String[rownum][colcount];
		for (int i = 1; i < rownum; i++)

		{
			for (int j = 0; j < colcount; j++) {
				Logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1,0
			}
		}
		return Logindata;
	}
}
