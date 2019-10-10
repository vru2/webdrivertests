// Framework - Cleartrip Automation
// Author - Kiran Kumar

package testScriptsIndiaHotels;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataServices.IndiaHotelDataProvider;
import domainServices.IndiaHotels;

	public class HotelCom_Payment_Partpay_Prod extends IndiaHotels{
	public RemoteWebDriver driver;
	private String baseUrl;
	private String TripID=null;
	
  @Test ( dataProviderClass = IndiaHotelDataProvider.class,dataProvider="HotelComPartPay")
  public void HotelCom_Partpay_Prod(String City, String CheckIn_Date, String CheckOut_Date, String Rooms, String Adult1, String Adult2, String Adult3, String Adult4, 
		   String Child1, String Child2, String ChildAge1, String ChildAge2, String Hotel_Name, String Payment_Type, String Logger_Msg, String Booking_Confirmation_Message) throws Exception {
	  	   driver.manage().deleteAllCookies();
	       hotelCom_DetailsPage(driver, "com",  dataFile.value("HotelID_PartPay_Prod"), 40, "");
	  	   hotelCom_AddCookie(driver);
		   hotelCom_ItineraryPage(driver, "PARTPAY");
		   hotelCom_TravelerPage(driver);
		   hotelCom_PaymentPage(driver, "NETBANKING", Logger_Msg, Booking_Confirmation_Message);
		   if(!elementVisible(driver, By.xpath("//div[@id='holdPayBlock']/nav/ul"), 10)){
			   Reporter.log("Part pay payment Block not displayed");
			   Assert.assertTrue(false);			   
		   }
  }
  
  @BeforeClass
  public void setUp() throws Exception {
	  driver=(RemoteWebDriver) getDriver(driver);
	  baseUrl = getBaseUrl( "com");
  }

  @AfterMethod (alwaysRun = true)
  public void takeScreenshot(ITestResult _result) throws Exception{
	screenshot(_result, driver);
  }
  
  @AfterClass
  public void tearDown() throws Exception {
	driver.quit();    
  }

}