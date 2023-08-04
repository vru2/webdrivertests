package test.java.  tripServices;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TS_PUT_Trips extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void PutTrips() throws Exception{
	Response resp;
	String url =  Service_Url("TRIPSERVICE_PUT_TRIPS");
	Reporter.log(url);
	resp=TripservicePutTrips(params_putTrips,headersForTripserviceputtripscall(),url);
	System.out.println(resp.asString());
	validation_puttrips(resp);
	}
	

}
