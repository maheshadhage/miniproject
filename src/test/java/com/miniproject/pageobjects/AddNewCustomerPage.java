package com.miniproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage

{
	WebDriver ldriver;

	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomername;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@FindBy(how = How.NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtaddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtcity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtstate;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtpinno;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtemailid;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement txtsubmit;

	// action methods

	public void ClickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void CustName(String cname) {
		txtCustomername.sendKeys(cname);
	}

	public void CustGender(String cgender) {
		rdGender.click();
	}

	public void Custdob(String mm, String dd, String yyyy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
	}

	public void CustAddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void CustCity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void CustState(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void CustPinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void CustTelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void Custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void Custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void CustSubmit() {
		txtsubmit.click();
	}
}
