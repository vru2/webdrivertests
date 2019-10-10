// Framework - cleartrip Automation
// Version -Web Driver 2.0
// Creation Date - 27 Aug 2015
// Author - Kiran Kumar
// Copyright � 2015 cleartrip Travel. All rights reserved.
package testScriptsAgencyCTPhoneBookings;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataServices.AgencyDataProvider;
import domainServices.Agency;

		public class CTPhoneAir_Coupon extends Agency{
		public RemoteWebDriver driver;

		@Test ( dataProviderClass = AgencyDataProvider.class,dataProvider="AirAgencyDom")	  
		public void CTPhoneCoupon(String FromCity, String ToCity, String From_Date, String To_Date, String Adults, String Childrens, String Infants, String Pref_Airline, String Payment_Type,  String Trip_Logger_Msg, String Booking_Confirmation_Message) throws Exception {
		  driver.get(CTPhone_Url());
		  CTPhone_SignIn(driver);
		  agencyAir_Oneway_Search(driver, FromCity, ToCity, From_Date, Adults, Childrens, Infants, Pref_Airline);
		  agencyAir_SRP_Domestic_Oneway(driver);
		  agencyAir_ItineraryPage(driver);
		  CTPhoneAir_TravellerPage(driver, Adults, Childrens, Infants);
		  CTPhoneAir_Paymentpage(driver, Payment_Type, "COUPON", Trip_Logger_Msg, "Air Agency Dom Oneway Coupon TripID : ");
		}

		@BeforeClass
		public void setUp() throws Exception {
		driver=(RemoteWebDriver) getDriver(driver);
		}
  
		@AfterMethod (alwaysRun = true)
		public void takeScreenshot(ITestResult _result) throws Exception{
		screenshot(_result, driver);
		}
  
		@AfterClass
		public void tearDown() throws Exception {
		browserClose(driver);
		}
}