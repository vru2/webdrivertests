// Framework - Cleartrip Automation
// Author - Kiran Kumar

package paymentsUI_Air;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class PWA_Coupon extends PaymentUI_Common{
	public RemoteWebDriver driver;
	
	@Test
	public void PWA_Coupon1() throws Exception {
		String PayUrl = getPayUI("AirCoupon", "");
		driver.manage().deleteAllCookies(); 
		driver.get(PayUrl);
		safeClick(driver, getObjectPayment("PWA_PaymentPage_FareBreakup_Icon"));
		elementPresent(driver, getObjectPayment("PWA_PaymentPage_FareBreakup_closeIcon"));
		textPresent_Log(driver, "Coupon code (DOMOW)", 5);
		safeClick(driver, getObjectPayment("PWA_PaymentPage_FareBreakup_closeIcon"));
		Thread.sleep(2000);
		payUI_Select_PaymentType_PWA(driver, "NET BANKING");
		textPresent(driver, "Choose another bank", 5);
		safeClick(driver, getObjectPayment("PWA_PaymentPage_Select_NB"));
		safeType(driver, getObjectPayment("PWA_NETBANKING_Page_NB_TextBox"), "Citibank");
		safeClick(driver, getObjectPayment("PWA_NETBANKING_Page_NB_AJAX"));
		Thread.sleep(5000);
		safeClick(driver, getObjectPayment("PayUI_Make_Payment_Btn2"));
		Thread.sleep(5000);		
		String Coupon_Invalid_Text = getText(driver, getObjectPayment("PWA_PaymentPage_Invalid_Coupon_Text"));
		if(!Coupon_Invalid_Text.contains("Coupon code DOMOW is not applicable on the chosen payment mode. Please update card details to avail benefits or proceed without coupon. Your updated price is")) {
			Reporter.log("Coupon code DOMOW is not applicable on the chosen payment mode. Please update card details to avail benefits or proceed without coupon. Your updated price is");
			Assert.assertTrue(false);
		}
		if(!Coupon_Invalid_Text.contains("800")) {
			Reporter.log("800 rs is not displayed");
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		safeClick(driver, getObjectPayment("PWA_PaymentPage_Coupon_Change_Payment_Button"));
		Thread.sleep(5000);
		safeClick(driver, getObjectPayment("PayUI_Make_Payment_Btn2"));
		Coupon_Invalid_Text = getText(driver, getObjectPayment("PWA_PaymentPage_Invalid_Coupon_Text"));
		if(!Coupon_Invalid_Text.contains("Coupon code DOMOW is not applicable on the chosen payment mode. Please update card details to avail benefits or proceed without coupon. Your updated price is")) {
			Reporter.log("Coupon code DOMOW is not applicable on the chosen payment mode. Please update card details to avail benefits or proceed without coupon. Your updated price is");
			Assert.assertTrue(false);
		}if(!Coupon_Invalid_Text.contains("800")) {
			Reporter.log("800 rs is not displayed");
			Assert.assertTrue(false);
		}
		safeClick(driver, getObjectPayment("PWA_PaymentPage_Book_Without_Coupon_Button"));		
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
