package testScriptsIndia;



	
	import java.util.HashMap;
	import java.util.LinkedList;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
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
	/*
	Test Case Description:	Add Meals to DOM OW RT GoAir flight. 
	*/


	public class testclass extends AirCommonMethod {

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

		
		@DataProvider(name = "B2CAirOW")
		public static Object[][] B2CAirRT() {
			String[] origin = { "DEL","MAA"};
			String[] destination = {"DXB","BLR"};
			return new Object[][] { { origin, destination, "Flights", "OneWay", "Air Arabia", "Air Arabia", "1", "0", "0",
					"credit card", "", false, false, "" } };
		}
		

		
		@Test(dataProvider= "B2CAirOW")
		public void Air_Dom_RT_Search(String[] fromSet, String[] toSet, String app, String tripType,
				String flightPreference, String flightFilterType, String adults, String children, String infants,
				String paymentMethod, String flightSegments, boolean insuranceRequired, boolean sector,
				String flight_type) throws Exception {
	 
			Reporter.log("Test case " + this.getClass() + " started");
			//System.out.println("Test case " + this.getClass() + " started");

			boolean warningFound = false;
			boolean flightCountFailure = true;
			int attempt = 0;

			

			do {
				driver.get(baseUrl);
				
				
				airCom_HomepageSearch_RoundTrip(driver, fromSet[attempt], toSet[attempt], "10", "12", adults, children, infants,
						flightPreference,attempt);
				Reporter.log("Search URL is : " + driver.getCurrentUrl());
				//System.out.println("Search URL is : " + driver.getCurrentUrl());
				
				flightCountFailure = checkFlightsCount1(driver);
				if (!flightCountFailure) {
					Reporter.log("No results found for this search. Making another attempt with different sectors.");
					//System.out.println("No results found for this search. Making another attempt with different sectors.");
					attempt++;
					continue;
				}
				//System.out.println("before filterflights");
				if (!flightPreference.equals("")) {
					warningFound = filterFlightsByPreferedAirline1(driver, flightPreference, 0);
					//System.out.println("after filterflights");
				//SelectCarrier(driver,"FZ");
					
					if (warningFound) {
						attempt++;
						continue;
					}
				}
				assertTrue("DOM RT Flight Results are Not Displayed", elementPresent(driver, getObject("AirCom_SRP_RoundTrip_BookButton")));
				
			} while (!flightCountFailure && attempt < 3);
			assertTrue("Search failed after 3 attempts", ((attempt < 4) && (flightCountFailure)));
			
					
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






