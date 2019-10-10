// Framework - Cleartrip Automation
// Author - Kiran Kumar

package com.cleartrip.payment.nodejs;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import domainServices.PaymentNodeJS;

	public class Payment_NodeJS_CTWallet_Full extends PaymentNodeJS{
	public RemoteWebDriver driver;
	private String baseUrl;
	
  @Test 
  public void paymentNodeJS_Wallet() throws Exception {
       driver.manage().deleteAllCookies(); 
	   driver.get(baseUrl);	   
	   paymentNodeJS_Select_Payment(driver, "CTFULL", "", "");
	   paymentNodeJS_Make_Payment(driver, "CTFULL", "");
	   paymentNodeJS_ConfirmationPage(driver, "CTFULL", "","CT Wallet Full ");
  }

  @BeforeClass
  public void setUp() throws Exception {
	driver=(RemoteWebDriver) getDriver(driver);
	baseUrl = getPaymentNodeUrl;
  }
  
  @AfterMethod (alwaysRun = true)
  public void afterMethod(ITestResult _result) throws Exception {
	 afterMethod(driver, _result);
  }
  
  @AfterClass
  public void tearDown() throws Exception {
	  browserClose(driver);
  }

}