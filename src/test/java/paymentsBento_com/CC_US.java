// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsBento_com;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CC_US extends PaymentUI_Common_Bento{
	public RemoteWebDriver driver;
	
	@Test
	public void CCUS() throws Exception {
		get_Bento_Url(driver, "AirUS", "US");
		bento_Select_PaymentType(driver, "CC");
		textPresent(driver, "Pay to complete your booking", 5);
		validate_Currency(driver, "", "$");
		payUI_Enter_PaymentDetails(driver, "CC", "MASTER","");
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver=(RemoteWebDriver) getDriver(driver);
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
