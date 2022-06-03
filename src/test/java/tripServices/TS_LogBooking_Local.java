package test.java.  tripServices;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TS_LogBooking_Local extends TripserviceCommon {
	
	@Test(groups={"Regression"})
	public void localPostCall() throws IOException, ClassNotFoundException, SQLException, InterruptedException{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_CALL");
		Reporter.log(url);
		resp=TripservicePostcall(params2,headersForTripservicepostcall(),url);
		Validation(resp);
		Thread.sleep(8000);
		DBValidation_Txn(resp, "O");
		}
	}
