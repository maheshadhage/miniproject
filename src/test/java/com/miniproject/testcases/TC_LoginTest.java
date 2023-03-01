package com.miniproject.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.miniproject.pageobjects.LoginPage;

public class TC_LoginTest extends BaseClass {
	@Test
	public void LoginTest() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver); // creating object of Login page and set username and PW
		lp.SetUsername(username);
		logger.info("entered username");

		// Thread.sleep(2000);

		lp.SetPassword(password);
		logger.info("entered password");
		// Thread.sleep(2000);

		lp.Clicksubmit();
		logger.info("clicked on submit");

		// Thread.sleep(2000);

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("TestCase Passed");

		} else {
			capturescreen(driver, "TC_LoginTest");
			Assert.assertTrue(false);
			logger.info("testCase Failed");

		}

	}

}
