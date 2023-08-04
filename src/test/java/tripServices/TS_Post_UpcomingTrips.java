package test.java.  tripServices;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TS_Post_UpcomingTrips extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void upcomingTripsPostCall() throws Exception {
		Response resp;
		String url = Service_Url("TRIPSERVICE_GETALL_TRIPS");
		Reporter.log(url);
		resp = TripserviceGetUpcomingTrips(params_getupcomingtrip, headersForTripservicepostcall(), url);
		validationforgetalltrips(resp);
		System.out.println(resp.asString());
	}
}
