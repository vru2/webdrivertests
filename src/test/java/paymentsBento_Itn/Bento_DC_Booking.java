package paymentsBento_Itn;

import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Bento_DC_Booking extends PaymentsBento_Itn_Common {

	@BeforeClass
	public void startSelenium() throws Exception {
		this.driver = getDriver(driver);
		baseUrl = getBaseUrl("com");
	}

	@Test
	public void bento_dc() throws Exception {
		driver.manage().deleteAllCookies();
		driver.navigate().to(qa2url + searchurl);
		System.out.println(qa2url + searchurl);
		Reporter.log(qa2url + searchurl);
		Searchpagebook(driver, "","com","");
		 book_itnnew(driver,""); 
		  Thread.sleep(1000);
		 if(textPresent(driver,"Pay to complete your booking", 30)) 
		 {
		  bento_paymentpage(driver,"storedcard","4111",""); 
		  confirmation_page(driver); 
		  }
		  
		  else if(textPresent(driver,"Sorry, our servers are stumped with your request",1)||textPresent(driver,"Flight not available",1)) 
		  {
		  System.out.println("Booking failed due to itn page issue");
		  Reporter.log("Booking failed due to itn page issue"); 
		  assertTrue(false); 
		  }
		  else
		  {
			  Reporter.log("Booking failed due to itn page issue");
			  assertTrue(false);
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
