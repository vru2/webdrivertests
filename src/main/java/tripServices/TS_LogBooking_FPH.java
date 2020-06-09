package tripServices;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TS_LogBooking_FPH extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void airPostCall() throws IOException, ClassNotFoundException, SQLException, InterruptedException{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_CALL");
		resp=TripservicePostcall(param_fph_log,headersForTripservicepostcall(),url);
		Validation(resp);
		Thread.sleep(4000);
		DBValidation_Txn(resp, "O");
			
	}
}
