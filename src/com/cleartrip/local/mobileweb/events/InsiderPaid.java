// Framework - Cleartrip Automation
// Version -Web Driver 2.0
// Creation Date - Feb, 2017
// Author - Kiran Kumar
// Copyright � 2017 Cleartrip Travel. All right reserved

package com.cleartrip.local.mobileweb.events;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import domainServices.Locals;

	public class InsiderPaid extends Locals{
	public RemoteWebDriver driver;

  @Test
  public void LocalsMobileWeb_EventsInsiderPaid_9013() throws Exception {
	 driver.manage().deleteAllCookies();  
	  locals_Events_Data_Refresh(driver, "Insider");
	 driver.get(locals_City_Events_URL);
	 locals_NameSearch_MobileWeb_Events(driver, "", dataFile.value("Locals_Data_Events_InsiderPaid"));
	 locals_BookFlow_MobileWeb(driver, "Events", "InsiderPaid");
	 locals_ItineraryPage(driver, "");
	 locals_PaymentPage(driver, "CC");
	 locals_Payment_ConfirmationPage_MobileWeb(driver, "MobileWeb Events Insider Paid : ", "");
  }

  @BeforeClass
  public void setUp() throws Exception {
	driver=getMobileDriver(driver);
	 // driver=getLocalMobileDriver(driver);
	baseUrl = common.value("murlLocals");
  }

	//@AfterMethod (alwaysRun = true)
	public void afterMethod(ITestResult _result) throws Exception {
		afterMethod_Local(driver, _result);
	}
  
  @AfterClass (alwaysRun = true)
  public void tearDown() throws Exception {
	browserClose(driver);
  }

}