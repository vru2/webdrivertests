package test.java.  tripServices;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TS_Post_ArchivedTrips extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void upcomingTripsPostCall() throws Exception{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_GETARCHIVED_TRIPS");
			Reporter.log(url);
			resp=TripserviceGetUpcomingTrips(params_get_archivedtrips,headersForTripservicepostcall(),url);
	    validationforgetalltrips(resp);
	    System.out.println(resp.asString());
 }
}
