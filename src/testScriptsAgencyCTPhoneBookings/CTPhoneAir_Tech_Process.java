// Framework - cleartrip Automation
// Version -Web Driver 2.0
// Creation Date - 21 Sep 2015
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

		public class CTPhoneAir_Tech_Process extends Agency{
		public RemoteWebDriver driver;

		@Test ( dataProviderClass = AgencyDataProvider.class,dataProvider="CTPhoneTechProcess", groups="Regression")	  
		public void CTPhoneBookings_Tech_Process_2202(String FromCity, String ToCity, String From_Date, String To_Date, String Adults, String Childrens, String Infants, String Pref_Airline, String Payment_Type, String Trip_Logger_Msg, String Booking_Confirmation_Message) throws Exception {
		  driver.manage().deleteAllCookies();
		  String SRP_URL = ctPhoneAir_SrpUrl(driver, FromCity, ToCity, Adults, Childrens, Infants, "DomOW", "", 40, 41);
		  driver.get(SRP_URL);
		  agencyAir_SRP_Domestic_Oneway(driver);
		  agencyAir_ItineraryPage(driver);
		  CTPhoneAir_TravellerPage(driver, Adults, Childrens, Infants);
		  agencyAir_Paymentpage(driver, Payment_Type, "", Trip_Logger_Msg, Booking_Confirmation_Message);
		}

		@BeforeClass
		public void setUp() throws Exception {
		driver=(RemoteWebDriver) getDriver(driver);
		}

		@AfterMethod (alwaysRun = true)
		public void afterMethod(ITestResult _result) throws Exception {
			afterMethod(driver, _result);
		}
  
		@AfterClass(alwaysRun = true)
		public void tearDown() throws Exception {
		browserClose(driver);
		}
}