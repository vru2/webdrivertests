package testScriptsIndia;


import static org.testng.AssertJUnit.assertTrue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataServices.HQDataProvider;
import domainServices.HQ;
import domainServices.AirCommonMethod;

public class AirDom_OW_VIA_Flight_LCC_Booking extends AirCommonMethod {

	public RemoteWebDriver driver = null;
	public LinkedList<HashMap<String, String>> assertionLinkedList = new LinkedList<HashMap<String, String>>();
	String tripId = null;
	String domain = "com";

	@BeforeClass
	public void startSelenium() throws Exception {
		this.driver = getDriver(driver);
		if (driver == null) {
			Reporter.log("Error in initial setup. Exiting without screenshot");
			throw new SkipException("Skipping Test: ");
		}
		baseUrl = getBaseUrl(domain);
	}

	@DataProvider(name = "DomOWVia")
	public static Object[][] B2CAirOWGDSDomViaParSectorManualRefund() {
		String[] origin = { "del","AMD","maa", "blr", "blr" };
		String[] destination = {"maa","SXR", "del", "amd", "jai" };
		String[] flightPreference={"SpiceJet","IndiGo"};
		return new Object[][] { { origin, destination, "Flights", "OneWay", "", "Non Direct", "1", "0", "0",
				"credit card", "via", false, false,flightPreference } };
	}

	@Test(dataProvider = "DomOWVia")
	public void airDom_OW_ViaFlight_lcc_booking_173(String[] fromSet, String[] toSet, String app, String tripType,
			String flightPreference, String flightFilterType, String adults, String children, String infants,
			String paymentMethod, String flightSegments, boolean insuranceRequired,boolean sector,
			String[] flight_type) throws Exception {

		Reporter.log("Test case " + this.getClass() + " started");
		//System.out.println("Test case " + this.getClass() + " started");

		
		
		boolean bookingPassed = false;
		boolean warningFound = false;
		boolean flightCountFailure = true;
		boolean paymentDone = false;
		int attempt = 0;

		

		do {
			driver.get(baseUrl);
			if (!checkIfSignedIn(driver)) {
				airCom_HomepageSignInForHQScripts(driver, domain);
			}
			
			
			airCom_HomepageSearch_Oneway(driver, fromSet[attempt], toSet[attempt], "10", adults, children, infants,
					flight_type[attempt], attempt);
			Reporter.log("Search URL for attempt is :" + driver.getCurrentUrl(),true);
			//System.out.println("Search URL for attempt is :" + driver.getCurrentUrl());
			
			flightCountFailure = checkFlightsCount1(driver);
			
			if (!flightCountFailure) {
				Reporter.log("No results found for this search. Making another attempt with different sectors.",true);
				//System.out.println("No results found for this search. Making another attempt with different sectors.");
				attempt++;
				continue;
			}
			
			
			if(elementPresent(driver,By.xpath("//div[2]/section/div/div[2]/nav[2]/ul/li[3]/a"),1)){
				driver.findElement(By.xpath("//div[2]/section/div/div[2]/nav[2]/ul/li[3]/a")).click();
				driver.findElement(By.xpath("//div[2]/section/div/div[2]/nav[2]/ul/li/a")).click();
				}
			
			warningFound = selectingStop(flightFilterType, driver,1);
			// getRefundableFlightsOnly(driver);
						//warningFound = flightTypeFilter(flightFilterType, driver, 0);
						// warningFound = selectingStop(flightFilterType, driver,0);
						if (warningFound) {
							attempt++;
							continue;
						}
						/*if (!flightPreference.equals("")) {
							warningFound = filterFlightsByPreferedAirline(driver, flightPreference, 0);
							if (warningFound) {
								attempt++;
								continue;
							}
						}*/
						
						warningFound = filterFlightsByLCCOrGDS2(driver, "lcc", 0);
						if (warningFound) {
							attempt++;
							continue;
						}
						
						/*WebElement pickedFlight = selectOneWayFlightDom(driver, flightSegments);
						if (pickedFlight == null) {
							attempt++;
							continue;
						} else {
							pickedFlight.findElement(getObject("AirCom_SRP_Oneway_BookButton_In_Picked_Flight_Dom")).click();
						}*/
						airCom_SRP_Oneway(driver);
			boolean failAfterBookButton = checkIfFailAfterBookButton(driver);
			if (failAfterBookButton) {
				Reporter.log("Redirected back to SRP after clicking on book button. Making another attempt",true);
				//System.out.println("Redirected back to SRP after clicking on book button. Making another attempt");
				attempt++;
				continue;
			}
			
			insuranceBlock(driver, insuranceRequired);
			travellerDetails(driver, adults, children, infants, false, false, false);
			Boolean reachedPaymentStep = airconditionWatcher(driver);
			if (reachedPaymentStep) {
				if ((common.value("makePayment").equals("true"))) {
					paymentDone = b2cPayment(driver, paymentMethod, 1);
					boolean error = false;
					if (paymentDone == true)
						error = recheckAirlinePrice(driver, "testFlag");//workaround
					else if (paymentDone == false) {
						attempt++;
						Reporter.log("Flight full error popped up. Re starting book process. Attempt number: " + attempt,true);
						continue;
					}
					if (error) {
						attempt++;
						continue;
					}
				} else {
					Reporter.log("Make Payment is set to false. Not attemptign Payment", true);
					bookingPassed = true;
					break;
				}
			} else {
				
				attempt++;
				Reporter.log("Flight full error popped up. Re starting book process. Attempt number: " + attempt, true);
				continue;
			}
			attempt++;
			bookingPassed = checkTripID(driver);
		} while (!bookingPassed && attempt < 5);
		assertTrue("Booking failed after 5 attempts", ((attempt < 6) && (bookingPassed)));

	}

	@AfterClass(alwaysRun = true)
	public void closeSelenium() throws Exception {
		// writeTripToFile(tripID);
		driver.close();
		driver.quit();
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult _result) throws Exception {
		afterMethod(driver, _result);
	}
}




