// Framework - Cleartrip Automation
// Version -Web Driver 2.0
// Creation Date - Jan, 2017
// Author - Kiran Kumar
// Copyright � 2017 Cleartrip Travel. All right reserved

package com.cleartrip.local.desktop.fnb;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import domainServices.Locals;

	public class CaraousalAdult extends Locals{
	public RemoteWebDriver driver;

	  @Test
	  public void LocalsFNB_Caraosal_Adult_5551() throws Exception {
	      driver.manage().deleteAllCookies();  
	      driver.get(locals_City_URL);	 
		  locals_NameSearch_FNB(driver, "Carousal", dataFile.value("Locals_Data_FNB_Caraousal_Name"));
		  locals_BookPopUP(driver, "FNB","AdultChild",1);
		  locals_ItineraryPage(driver,"Coupon");
		  locals_PaymentPage(driver, "");	
		  //locals_PaymentPage(driver, "SC");
		  locals_Payment_ConfirmationPage(driver, "FNB Adult Caraousal: ", "");
  }

  @BeforeClass
  public void setUp() throws Exception {
		driver=(RemoteWebDriver) getDriver(driver);
  }

  	//@AfterMethod (alwaysRun = true)
	public void afterMethod(ITestResult _result) throws Exception {
		afterMethod_Local(driver, _result);
	}
  
  @AfterClass
  public void tearDown() throws Exception {
	browserClose(driver);
  }

}