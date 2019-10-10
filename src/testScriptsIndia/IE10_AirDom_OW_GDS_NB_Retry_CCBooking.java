package testScriptsIndia;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;
import domainServices.AirCommonMethod;


	public class IE10_AirDom_OW_GDS_NB_Retry_CCBooking extends AirCommonMethod { 
		
		
		public RemoteWebDriver driver = null;
		public LinkedList<HashMap<String, String>> assertionLinkedList = new LinkedList<HashMap<String, String>>();
		String tripId = null;
		boolean flowCorrect = false;
		String domain = "com";

		@BeforeClass
		public void startSelenium() throws Exception {
		driver=(RemoteWebDriver) IE_Config(driver, "10");
		this.driver = getDriver(driver);
			if (driver == null) {
				Reporter.log("Error in initial setup. Exiting without screenshot");
				throw new SkipException("Skipping Test: ");
			}
			baseUrl = getBaseUrl(domain);
		}

		@DataProvider(name = "B2CAirOWGDS")
		public static Object[][] B2CAirOWGDS() {
			String[] origin = { "bom","del","blr"};
			String[] destination = {"del","bom","bom"};
			return new Object[][] { { origin, destination, "Flights", "OneWay", "", "Vistara", "", "1", "0", "0",
					"credit card", false} };
		}
		
		
		@Test(dataProvider = "B2CAirOWGDS")
		public void Air_Dom_OW_GDS_NB_Retry_CCBooking(String[] fromSet, String[] toSet, String app, String tripType, String flight_type,
				String flightPreference, String flightFilterType, String adults, String children, String infants,
				String paymentMethod, boolean insuranceRequired) throws Exception {

				
			boolean bookingPassed = false;
			boolean warningFound = false;
			boolean flightCountFailure = true;
			boolean paymentDone = false;
			int attempt = 0;

			Runtime rt = Runtime.getRuntime();
			Process p = rt.exec("ipconfig");
			Reporter.log(p.toString());
					
			do {
				driver.get(baseUrl);
				
				homepageSignIn(driver, domain, dataFile.value("AirUserIdForHQScripts"), dataFile.value("AirPasswordForHQScripts"));
				/*if (!checkIfSignedIn(driver)) {
					
					airCom_HomepageSignInForHQScripts(driver, domain);
				}*/
				
				airCom_HomepageSearch_Oneway(driver, fromSet[attempt], toSet[attempt], "10", adults, children, infants,
						flightPreference,attempt);
				Reporter.log("Search URL is : " + driver.getCurrentUrl());
				
				flightCountFailure = checkFlightsCount1(driver);
				if (!flightCountFailure) {
					Reporter.log("No results found for this search. Making another attempt with different sectors.");
					//System.out.println("No results found for this search. Making another attempt with different sectors.");
					attempt++;
					continue;
				}
			
				warningFound = filterFlightsByLCCOrGDS1(driver, flight_type, 0);
				if (warningFound) {
					attempt++;
					continue;
				}
				
				//airCom_SRP_Oneway(driver);
				
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
					attempt++;
					continue;
				}
				cheaperRateBlock(driver);
				assertionLinkedList = captureItineraryData(driver);
			
				insuranceBlock(driver, insuranceRequired);
				
				travellerDetails(driver, adults, children, infants, false, false, false);
			
				airconditionWatcher(driver);
				PaymentRetry(driver, "NB");
			
			Boolean reachedPaymentStep = airconditionWatcher(driver);
			if (reachedPaymentStep) {
				paymentDone = b2cPayment(driver, paymentMethod, 1);
				if (paymentDone == true)
					recheckAirlinePrice(driver);
				else if (!(common.value("makePayment").equals("true")))
					break;
				else if (paymentDone == false) {
					attempt++;
					Reporter.log("Flight full error popped up. Re starting book process. Attempt number: " + attempt);
					continue;
				}
			} else {
				attempt++;
				Reporter.log("Flight full error popped up. Re starting book process. Attempt number: " + attempt);
				continue;
			}
			attempt++;
			bookingPassed = checkBookingStatus(driver);
				
		} while (!bookingPassed && attempt < 3);
			assertTrue("Booking failed after 3 attempts", ((attempt < 4) && (bookingPassed)));
			
		}
		
		
		
		@AfterClass(alwaysRun = true)
		public void closeSelenium() throws Exception {
			driver.close();
			driver.quit();
		}

		@AfterMethod(alwaysRun = true)
		public void takeScreenshot(ITestResult _result) throws Exception {
			screenshot(_result, driver);
			//System.out.println("Test Case:" + _result.getMethod().getMethodName());
		}


	}








