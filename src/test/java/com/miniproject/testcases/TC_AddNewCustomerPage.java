package com.miniproject.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.miniproject.pageobjects.AddNewCustomerPage;
import com.miniproject.pageobjects.LoginPage;

public class TC_AddNewCustomerPage extends BaseClass {
	@Test
	public void addnewcustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.SetUsername(username);
		lp.SetPassword(password);
		lp.Clicksubmit();

		AddNewCustomerPage add = new AddNewCustomerPage(driver);
		add.ClickAddNewCustomer();
		add.CustName("pavan");
		Thread.sleep(3000);
		add.CustGender("male");
		add.Custdob("4", "7", "1998");
		Thread.sleep(3000);
		add.CustAddress("takali-kazi ,tal-dist-ahmednagar");

		Thread.sleep(3000);
		add.CustCity("pune");
		Thread.sleep(3000);
		add.CustState("Maharashtra");
		add.CustPinno("123445");
		Thread.sleep(3000);
		add.CustTelephoneno("98989898");
		Thread.sleep(3000);

		String mail = RandomString() + "@gmail.com";
		add.Custemailid(mail);
		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("TestCase Passed");

		} else {
			logger.info("TestCase Failed");
			capturescreen(driver, "addnewcustomer");
			Assert.assertTrue(false);
		}

	}
}
