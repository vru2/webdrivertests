package com.cleartrip.local.desktop.fnb;



import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import domainServices.Locals;

public class SEOYouMightAlsoLike extends Locals{
	public RemoteWebDriver driver;
	String tripId = null, cashBack = null;

	@Test
	public void localsFnbSEOYouMightAlsoLike_40044() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(locals_City_URL);
		safeClickList(driver, getObjectLocals("LocalCom_HomePage_Activity_TabNEW"), "Eat Out");
		fnbYouMightAlsoLike(driver,"AlsoLike");
}
	@BeforeClass
	public void setUp() throws Exception {
		driver = (RemoteWebDriver) getDriver(driver);
	}

//	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult _result) throws Exception {
		afterMethod_Local(driver, _result);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		browserClose(driver);
	}

}
