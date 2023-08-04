package test.java.tripServices;

import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TS_UpdateBooking_Bus extends TripserviceCommon {

	@Test(groups={"Regression"})
	public void Tripserviceairputcall() throws IOException, ClassNotFoundException, SQLException, InterruptedException
	{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_CALL");
		Reporter.log(url);
		resp=TripservicePostcall(paramsbus,headersForTripservicepostcall(),url);
		validationforputcall(resp);		
		Response resp1;
		String url1 = ("http://trip-service-api.cltp.com:9001/trips/"+tripref+"/bus-bookings/update-booking");
		Reporter.log(url1);
		resp1=TripserviceBusPutcall(paramsbusupdate,headersForTripservicebusputtripscall(),url1);
		System.out.println(resp1.asString());
		validationforput(resp1);
		Thread.sleep(8000);		
		DBValidation_Txn(resp, "C");	
 }
}
