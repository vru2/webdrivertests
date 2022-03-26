package paymentsBento_Itn_Hotels;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IN_DC_Razorpay extends PaymentsBento_Itn_Hotels_Common {

	@BeforeClass
	public void startSelenium() throws Exception {
		this.driver = getDriver(driver);
	}

	@Test
	public void Hotel_IN_DC() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(hotelDetailsUrl("IN","sri-balaji-paradise-2626774"));
		hotelsDetailsPage(driver, "", "");
		hotelsItnPage(driver, "", "", "", "");
		hotelsPaymentPage(driver,"CC","4111","","","");
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
