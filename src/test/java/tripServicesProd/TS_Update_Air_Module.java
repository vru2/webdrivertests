package test.java.  tripServicesProd;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

//import com.jayway.restassured.path.json.JsonPath;

import io.restassured.response.Response;

public class TS_Update_Air_Module extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void airPostCall() throws Exception{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_CALL");
		resp=TripservicePostcall(params,headersForTripservicepostcall(),url);
		Validation(resp);
		JsonPath jsonPath = new JsonPath(resp.asString());
		String tripref = jsonPath.getString("trip_ref");
		Response resp1;
		String randNum="5";
		String api_tp_wallet_amt=randNum;
		String params11=(params8+db_AirBookingId(tripref))+params9+randNum+params10;
		String Host = common.value("host");
		if((Host.equalsIgnoreCase("qa2"))) {
		String url1=("http://172.17.26.11:9031/trips");
		resp1=TripserviceUpdateModule(params11,headersForTripserviceputtripscall(),url1);
		Thread.sleep(2000);
		validationforputtrips(resp1);
		}
		DBValidation_airbookingdetails(resp,api_tp_wallet_amt);
		}
}
