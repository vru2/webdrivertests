package com.cleartrip.local.desktop.wl.ttd;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import domainServices.Locals;

public class SEONearYou extends Locals{
	public RemoteWebDriver driver;
	String tripId = null, cashBack = null;

	@Test
	public void localsWlTtdSeoNearYou_40050() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(localsWL_City_URL);
		ttdWlYouMightAlsoLike(driver,"NearYou");	
}
	@BeforeClass
	public void setUp() throws Exception {
		driver = (RemoteWebDriver) getDriver(driver);
	}

	//@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult _result) throws Exception {
		afterMethod_Local(driver, _result);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		browserClose(driver);
	}

}
