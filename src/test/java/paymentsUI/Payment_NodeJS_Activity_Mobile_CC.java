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

	public class Payment_NodeJS_Activity_Mobile_CC extends PaymentNodeJS{
	public RemoteWebDriver driver;
	private String baseUrl;
	
  @Test 
  public void paymentNodeJS_Acty_Mobile_CC() throws Exception {
       driver.manage().deleteAllCookies(); 
	   driver.get(baseUrl);	   
	   paymentNodeJS_HomePage(driver, "", "");
	   paymentNodeJS_Select_Source(driver, "MOBILE", "");
	   paymentNodeJS_Select_Product(driver, "ACTIVITY", "");
	   paymentNodeJS_Select_Payment(driver, "CC", "", common.value("testcardtype"));
	   paymentNodeJS_Make_Payment(driver, "CC",common.value("testcardtype"));
	   paymentNodeJS_ConfirmationPage(driver, "CC", "","Activity Mobile CC");
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