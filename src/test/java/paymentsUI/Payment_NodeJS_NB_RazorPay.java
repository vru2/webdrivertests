// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsUI;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.java.domains.PaymentNodeJS;

	public class Payment_NodeJS_NB_RazorPay extends PaymentNodeJS{
	public RemoteWebDriver driver;
	private String baseUrl;
	
  @Test 
  public void paymentNodeJS_RazorPay() throws Exception {
	   driver.manage().deleteAllCookies(); 
	   if(!ProductionUrl) { 
	       driver.get(baseUrl);	   
		   paymentNodeJS_Select_Payment(driver, "NB", "ICICI Bank", "");
		   paymentNodeJS_Make_Payment(driver, "NB", "ICICI Bank");
		   paymentNodeJS_ConfirmationPage(driver, "RAZORPAYNB", "","RAZORPAYNB ");
	   }
  }

  @BeforeClass
  public void setUp() throws Exception {
	driver=(RemoteWebDriver) getDriver(driver);
	baseUrl = getPaymentNodeUrl;
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