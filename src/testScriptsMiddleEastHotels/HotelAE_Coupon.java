// Framework - cleartrip Automation
// Version -Web Driver 2.0
// Creation Date - OCT, 2015
// Author - Kiran Kumar
// Copyright � 2015 cleartrip Travel. All right reserved.
package testScriptsMiddleEastHotels;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataServices.MiddleEastDataProvider;
import domainServices.IndiaHotels;

	public class HotelAE_Coupon extends IndiaHotels{
	public RemoteWebDriver driver;
	private String baseUrl;

  @Test ( dataProviderClass = MiddleEastDataProvider.class,dataProvider="HotelAECoupon")
  public void HotelAECoupon_614(String City, String CheckIn_Date, String CheckOut_Date, String Rooms, String Adult1, String Adult2, String Adult3, String Adult4, 
								String Child1, String Child2, String ChildAge1, String ChildAge2, String Hotel_Name, String Payment_Type, String Logger_Msg, String Booking_Confirmation_Text) throws Exception {
	  driver.manage().deleteAllCookies(); 
	  driver.get(baseUrl);
	   hotelCom_HomepageSearch(driver, City, CheckIn_Date, CheckOut_Date, Rooms, Adult1, Adult2, Adult3, Adult4, Child1, Child2,  ChildAge1, ChildAge2);
	   hotelCom_SRP(driver, Hotel_Name,"");
	   hotelCom_ItineraryPage(driver, "Coupon");
	   hotelCom_LoginPage(driver, "SignIn","");
	   hotelCom_TravelerPage(driver);
	   hotelCom_PaymentPage(driver, Payment_Type, Logger_Msg, Booking_Confirmation_Text);
	   hotelCom_ConfirmationPageValidation(driver, "COUPONAE", "", "Your booking is done");
 }
  
  @BeforeClass
  public void setUp() throws Exception {
	driver=(RemoteWebDriver) Chrome_Config(driver);
	baseUrl = getBaseUrl( "ae");
	driver.manage().deleteAllCookies();
  }
  
  @AfterMethod (alwaysRun = true)
	public void afterMethod(ITestResult _result) throws Exception {
		afterMethod(driver, _result);
	}
  
  @AfterClass
  public void tearDown() throws Exception {
	  driver.quit();    
  }

}