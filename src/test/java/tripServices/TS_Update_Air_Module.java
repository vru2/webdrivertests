package test.java.  tripServices;

import org.testng.Reporter;
import org.testng.annotations.Test;

//import com.jayway.restassured.path.json.JsonPath;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_Update_Air_Module extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void airPostCall() throws Exception{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_CALL");
		Reporter.log(url);
		resp=TripservicePostcall(params,headersForTripservicepostcall(),url);
		validationforputcall(resp);
		Response resp1;
		String randNum="5";
		String api_tp_wallet_amt=randNum;
		String params11=(params8+db_AirBookingId(tripref))+params9+randNum+params10;
		String Host = common.value("host");
		if((Host.equalsIgnoreCase("qa2"))) {
		String url1=("http://trip-service-api.cltp.com:9001/trips");
		Reporter.log(url1);
		resp1=TripserviceUpdateModule(params11,headersForTripserviceputtripscall(),url1);
		Thread.sleep(2000);
		validationforputtrips(resp1);
		}
		Thread.sleep(8000);
		DBValidation_airbookingdetails(resp,api_tp_wallet_amt);
		}
}
