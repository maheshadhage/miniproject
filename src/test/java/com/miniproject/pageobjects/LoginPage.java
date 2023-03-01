package com.miniproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement btnLogout;

	public void SetUsername(String Uname) {
		txtUserName.sendKeys(Uname);
	}

	public void SetPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void Clicksubmit() {
		btnLogin.click();
	}

	public void Clicklogout() {
		btnLogout.click();
	}
// driver.switchTo().alert().accept();
// driver.switchTo().defaultContent();
}
