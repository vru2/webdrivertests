package test.java.paymentsBento_Itn;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Bento_BH_PayU_Booking extends PaymentsBento_Itn_Common {

	@BeforeClass
	public void setUp() throws Exception {
		driver=(RemoteWebDriver) getDriver(driver);
	}

	@Test
	public void bento_bh_booking() throws Exception {
		driver.manage().deleteAllCookies();
		driver.navigate().to(searchurl("BH"));
		System.out.println(searchurl("BH"));
		Reporter.log(searchurl("BH"));
		Searchpagebook(driver,"","","");
		noncom_itnpage(driver,"","");
		paymentPage(driver,"OTH","","","","");
	}

	@AfterClass
	public void closeSelenium() throws Exception {
		 browserClose(driver);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult _result) throws Exception {
			afterMethod(driver, _result);
	}

}
