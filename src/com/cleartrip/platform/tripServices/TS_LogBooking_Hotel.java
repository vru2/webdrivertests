package com.cleartrip.platform.tripServices;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TS_LogBooking_Hotel extends TripserviceCommon {
	
	@Test(groups={"Regression"})
	public void hotelPostCall() throws IOException, ClassNotFoundException, SQLException, InterruptedException{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_CALL");
		resp=TripservicePostcall(params1,headersForTripservicepostcall(),url);
		Validation(resp);
		DBValidation_Txn(resp, "O");
		
	}
}
