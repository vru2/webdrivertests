package paymentsBento_Itn;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Bento_OM_Booking extends PaymentsBento_Itn_Common {

	@BeforeClass
	public void setUp() throws Exception {
		driver=(RemoteWebDriver) getDriver(driver);
	}

	@Test
	public void bento_qa_booking() throws Exception {
		driver.manage().deleteAllCookies();
		/*
		 * driver.navigate().to(aeurl); Thread.sleep(2000);
		 */
		driver.navigate().to(omurl+searchurl);
		System.out.println(omurl+searchurl);
		Reporter.log(omurl+searchurl);
		Searchpagebook(driver,"");
		noncom_itnpage(driver,"","");
	    if(textPresent(driver,"Sorry, our servers are stumped with your request",30)||textPresent(driver,"Flight not available",30))
	    {
	    	System.out.println("Booking failed due to itn page issue");
	    	Reporter.log("Booking failed due to itn page issue");
	    	assertTrue(false);
	    }
	    else
	    {
	    bento_paymentpage(driver,"OTH","");
	    confirmation_page(driver);
	    }
	    
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
