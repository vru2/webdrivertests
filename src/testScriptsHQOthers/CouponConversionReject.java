package testScriptsHQOthers;

import static org.testng.AssertJUnit.assertTrue;

import java.util.HashMap;
import java.util.LinkedList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataServices.HQDataProvider;
import domainServices.HQ;
import domainServices.AirCommonMethod;

public class CouponConversionReject extends AirCommonMethod {
	public RemoteWebDriver driver = null;
	public LinkedList<HashMap<String, String>> assertionLinkedList = new LinkedList<HashMap<String, String>>();
	String tripId = null;
	boolean flowCorrect = false;
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

	/*
	 * @DataProvider(name = "CouponConversionConvert") public static Object[][] CouponConversionReject() { String[] origin = {
	 * "del", "hyd"}; String[] destination = { "amd", "maa"}; return new Object[][] { { origin, destination, "Flights", "OneWay",
	 * "lcc", "Indigo", "Direct", "1", "0", "0", "credit card", false } }; }
	 */

	@BeforeMethod
	public void beforeMethod() {
		timer();
	}

	@Test(groups = "Regression", dataProviderClass = HQDataProvider.class, dataProvider = "CouponConversionConvert")
	public void couponConversionReject(String[] fromSet, String[] toSet, String app, String tripType, String flight_type,
			String flightPreference, String flightFilterType, String adults, String children, String infants,
			String paymentMethod, boolean insuranceRequired) throws Exception {

		Reporter.log("Test case " + this.getClass() + " started");
		System.out.println("Test case " + this.getClass() + " started");

		boolean bookingPassed = false;
		boolean warningFound = false;
		boolean flightCountFailure = true;
		boolean paymentDone = false;
		int attempt = 0;

		HQ hq = new HQ();

		do {
			driver.get(baseUrl);
			if (!checkIfSignedIn(driver)) {
				airCom_HomepageSignInForHQScripts(driver, domain);
			}
			// safeClick(driver, getObject("AirSideAppButtonXPath"));
			airCom_HomepageSearch_Oneway(driver, fromSet[attempt], toSet[attempt], "10", adults, children, infants,
					flightPreference, attempt);
			Reporter.log("Search URL for attempt is :" + driver.getCurrentUrl());
			// System.out.println("Search URL for attempt is :" + driver.getCurrentUrl());
			flightCountFailure = checkFlightsCount(driver);
			if (!flightCountFailure) {
				Reporter.log("No results found for this search. Making another attempt with different sectors.");
				// System.out.println("No results found for this search. Making another attempt with different sectors.");
				attempt++;
				continue;
			}
			warningFound = flightTypeFilter(flightFilterType, driver, 0);
			if (warningFound) {
				attempt++;
				continue;
			}
			if (!flightPreference.equals("")) {
				warningFound = filterFlightsByPreferedAirline(driver, flightPreference, 0);
				if (warningFound) {
					attempt++;
					continue;
				}
			}
			WebElement we = pickFirstFlight(driver);
			if (we != null) {
				bookButtonDom(we);
			} else {
				Reporter.log("No flight satisfies the required criteria among the loaded results. Trying with new combination.");
				attempt++;
				continue;
			}
			boolean failAfterBookButton = checkIfFailAfterBookButton(driver);
			if (failAfterBookButton) {
				Reporter.log("Redirected back to SRP after clicking on book button. Making another attempt");
				// System.out.println("Redirected back to SRP after clicking on book button. Making another attempt");
				attempt++;
				continue;
			}
			cheaperRateBlock(driver);
			// assertionLinkedList = captureItineraryData(driver);
			insuranceBlock(driver, insuranceRequired);
			travellerDetails(driver, adults, children, infants, false, false, false);
			Boolean reachedPaymentStep = airconditionWatcher(driver);
			if (reachedPaymentStep) {
				if ((common.value("makePayment").equals("true"))) {
					paymentDone = b2cPayment(driver, paymentMethod, 1);
					boolean error = false;
					if (paymentDone == true)
						error = recheckAirlinePrice(driver, "testFlag");// workaround
					else if (paymentDone == false) {
						attempt++;
						Reporter.log("Flight full error popped up. Re starting book process. Attempt number: " + attempt);
						continue;
					}
					if (error) {
						attempt++;
						continue;
					}
				} else {
					bookingPassed = true;
					break;
				}
			} else {
				attempt++;
				Reporter.log("Flight full error popped up. Re starting book process. Attempt number: " + attempt);
				continue;
			}
			attempt++;
			bookingPassed = checkBookingStatus(driver);
		} while (!bookingPassed && attempt < 2);
		assertTrue("Booking failed after 3 attempts", ((attempt < 4) && (bookingPassed)));

		if (paymentDone) {
			// System.out.println("Booking Passed");
			tripId = getTripId(driver, getObject("AirCom_Confirmation_TripID"));
			// sendSMS(driver);// TODO:
			signOut(driver, domain);

			Thread.sleep(15000);
		}

		if (common.value("HQFlowFlag").equals("true") && common.value("makePayment").equals("true")) {
			driver.get(getBaseUrl(domain) + "/hq");
			hq.signInHQ(driver);
			hq.confirmTripLoad(driver, tripId, domain);
			String status;
			Boolean converted = false;
			attempt = 0;
			do {
				attempt++;
				Thread.sleep(10000);
				driver.navigate().refresh();
				status = hq.getBookingStatus(driver);
				Reporter.log("Booking status is " + status);
				// System.out.println("Booking status is " + status);
				if (hq.checkIfStatusConfirmedForAllSegment(driver) || status.equals("Booking Failed")) {
					Reporter.log("Booking status should have been Hold (Airline Coupon). Check if RateRUle is properly defined!");
					System.out
							.println("Booking status should have been Hold (Airline Coupon). Check if RateRUle is properly defined!");
					assertTrue("Failure!", false);
				}
			} while (!status.equals("Hold (Airline Coupon)") && attempt < 5);
			if (status.equals("Hold (Airline Coupon)")) {
				hq.processCouponConversion(driver, tripId, "cancel");
				hq.confirmTripLoad(driver, tripId, domain);
				converted = true;
				status = hq.getBookingStatus(driver);
			} else {
				Reporter.log("Booking status should have been Hold (Airline Coupon). Check if RateRUle is properly defined!");
				System.out
						.println("Booking status should have been Hold (Airline Coupon). Check if RateRUle is properly defined!");
				assertTrue("Failure!", false);
			}
			if (converted && status.equals("Hold (Airline Coupon)")) {
				if (isElementPresent(driver, getObject("Air_HQ_Trip_Details_Refunds_Tab"))) {
					Reporter.log("Test case " + this.getClass() + " passed successfully");
					System.out.println("Test case " + this.getClass() + " passed successfully");
				} else {
					for (int i = 0; i < 5; i++) {
						hq.confirmTripLoad(driver, tripId, domain);
						if (isElementPresent(driver, getObject("Air_HQ_Trip_Details_Refunds_Tab"))) {
							Reporter.log("Test case " + this.getClass() + " passed successfully");
							System.out.println("Test case " + this.getClass() + " passed successfully");
							return;
						}
					}
					Reporter.log("Coupon conversion cancelled from Coupon conversion queue, but refund did not happen!");
					// System.out.println("Coupon conversion cancelled from Coupon conversion queue, but refund did not happen!");
					assertTrue("Failure!", false);
				}
			} else if (converted && !hq.checkIfStatusConfirmedForAllSegment(driver)) {
				Reporter.log("Booking status after conversion is " + status + ". Coupon conversion Failed!");
				// System.out.println("Booking status after conversion is " + status + ". Coupon conversion Failed!");
				assertTrue("Failure!", false);
			}
		}
	}

	@AfterClass
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
