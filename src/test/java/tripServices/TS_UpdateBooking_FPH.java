package test.java.  tripServices;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TS_UpdateBooking_FPH extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void Tripserviceairputcall() throws IOException, ClassNotFoundException, SQLException, InterruptedException
	{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_CALL");
	    Reporter.log(url);
		resp=TripservicePostcall(param_fph_log,headersForTripservicepostcall(),url);
		validationforputcall(resp);		
		Response resp1;
		String Host = common.value("host");
		if(Host.equalsIgnoreCase("qa2")) {
		String url1 = ("http://trip-service-api.cltp.com:9001/trips/"+tripref+"/fph-bookings/update-booking");
		Reporter.log(url1);
		resp1=TripserviceHotelsPutcall(param_fph_update,headersForTripserviceputcall(),url1);
		validationforput(resp1);	
	} else if(Host.equalsIgnoreCase("dev")) {
		String url1 = ("http://172.17.32.12:9031/trips/"+tripref+"/fph-bookings/update-booking");
		resp1=TripserviceHotelsPutcall(param_fph_update,headersForTripserviceputcall(),url1);
		validationforput(resp1);	
		} /*
			 * else if (Host.equalsIgnoreCase("www")) { String url1 =
			 * ("http://172.21.48.21:9031/trips/"+tripref+"/fph-bookings/update-booking");
			 * resp1=TripserviceHotelsPutcall(param_fph_update,headersForTripserviceputcall(
			 * ),url1); validationforput(resp1); }
			 */
		Thread.sleep(12000);
		DBValidation_Txn(resp, "C");	
 }
}
