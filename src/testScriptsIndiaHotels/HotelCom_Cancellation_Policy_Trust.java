// Framework - Cleartrip Automation
// Author - Kiran Kumar

package testScriptsIndiaHotels;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import domainServices.IndiaHotels;

	public class HotelCom_Cancellation_Policy_Trust extends IndiaHotels{
	public RemoteWebDriver driver;	

  @Test 
  public void HotelCom_CancellationPolicyTrust() throws Exception {
		 driver.manage().deleteAllCookies();   
		 driver.get(detailsPage_URL_Link(driver, "com", dataFile.value("HotelID_Cancellation_Trust"), 40));
		 hotelCom_DetailsPage_CancellationPolicy(driver, "TRUST", CancellationPolicy_Trust);	 
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