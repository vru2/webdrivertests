package testScriptsCorpIndia;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import domainServices.Corporate;

public class AirCorp_Intl_OW_Hold_To_Confirm extends Corporate {
	public RemoteWebDriver driver;
	boolean flightCountFailure = true;
	String domain = "com";
	String TripID = null;
	
	@DataProvider
	public static Object[][] AirCorp() {
		return new Object[][] { { "CMB", "MAA", "19", "20", "1", "0", "0", "","gds","" } };
	}

	@Test(dataProvider = "AirCorp")
	public void airCorpIntl_HoldToConfirm_234(String FromCity, String ToCity, String From_Date, String To_Date, String Adults, String Childrens,
			String Infants, String Pref_Airline,String flight_type,String Payment_Type) throws Exception {

		driver.manage().deleteAllCookies();
		String SRP_URL = corpCom_Air_SrpUrl(driver, FromCity, ToCity, Adults, Childrens, Infants, "IntlOW", Pref_Airline , 45, 46);
		driver.get(SRP_URL);
		corpAir_SRP(driver, "INTLHOLD", flight_type);			
		corpAir_ItineraryPage(driver);
		corpAir_Intl_TravellerPage(driver, Adults, Childrens, Infants);
		TripID = AirCorpPayment_Hold(driver);
		
		if(MakePaymentOnlyInQA2){
			 AirCorp_Paymentpage(driver, Payment_Type, "", "Corp Intl OW Hold : ");
		  } 
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult _result) throws Exception {
		afterMethod(driver, _result);
	}

	
	@BeforeClass
	public void setUp() throws Exception {
		driver = (RemoteWebDriver) getDriver(driver);
		baseUrl = getBaseUrl(domain);
	}
	/*@BeforeClass
	public void setUp() throws Exception {
		driver = getDriver(driver);
		baseUrl = getBaseUrl(domain);
	}*/
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		browserClose(driver);
	}
}