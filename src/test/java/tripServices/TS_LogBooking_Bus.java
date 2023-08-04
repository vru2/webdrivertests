package test.java.tripServices;

import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TS_LogBooking_Bus extends TripserviceCommon {
	
	@Test(groups={"Regression"})
	public void busPostCall() throws IOException, ClassNotFoundException, SQLException, InterruptedException{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_CALL");
		Reporter.log(url);
		resp=TripservicePostcall(paramsbus,headersForTripservicepostcall(),url);
		System.out.println(resp.asString());
		Validation(resp);
		Thread.sleep(4000);
		DBValidation_Txn(resp, "O");
			
	}
}
