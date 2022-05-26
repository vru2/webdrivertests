// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsUI_Air;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PWA_AmazonPay extends PaymentUI_Common{
	public RemoteWebDriver driver;
	
	@Test
	public void PWA_AmazonPay() throws Exception {
		String PayUrl = getPayUI("Air", "");
		driver.manage().deleteAllCookies(); 
		driver.get(PayUrl);
		refreshPage(driver);
		payUI_Select_PaymentType_PWA(driver, "TW");
		
		payUI_Enter_PaymentDetails_PWA(driver, "TW", "AmazonPay");
		if(common.value("Bento_Payment").equalsIgnoreCase("true")) {
		elementPresent(driver, getObjectPayment("MakePayment_Amazon_Page_Signin_Email"));
		textPresent_Log(driver, "Login with your Amazon account", 20);
		safeType(driver, getObjectPayment("MakePayment_Amazon_Page_Signin_Email"), "kiran.kumar@cleartrip.com");
		safeType(driver, getObjectPayment("MakePayment_Amazon_Page_Signin_Password"), "Cleartrip@123");
		safeClick(driver, getObjectPayment("MakePayment_Amazon_Page_Signin_Login"));
		elementPresent(driver, getObjectPayment("MakePayment_Amazon_Page_SelectCard"));
		scrollSmooth(driver, 1000);
		safeClick(driver, getObjectPayment("MakePayment_Amazon_Page_SelectCard"));
		safeType(driver, getObjectPayment("MakePayment_Amazon_Page_SelectCard_CVV"), "123");
		
		safeClick(driver, getObjectPayment("MakePayment_Amazon_Page_Pay_Button"));
		payUI_Mock_ConfirmationPage(driver, PayUrl);
		}
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver=(RemoteWebDriver) getMobileDriver(driver);
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
