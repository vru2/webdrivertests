package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TS_GET_CancelledInsurance extends TripserviceCommon {
	
	@Test(groups={"Regression"})
	public void getCancelledInsurance(){
		Reporter.log("http://trip-service-api.cltp.com:9001/trips/cancelledInsurances?date=05-07-2023");
		Response resp=RestAssured.given().
				      when().
				      log().all().
				      headers(headersForTripservicepostcall()).
				      get("http://trip-service-api.cltp.com:9001/trips/cancelledInsurances?date=05-07-2023");
		    System.out.println(resp.asString());
			if(resp.statusCode()==200){
				ResponseBody body= resp.getBody();
				String bodyAsString = body.asString();
				Assert.assertEquals(bodyAsString.contains("Refund"), true ,"Response boday contains Refund");

			}else{
			Reporter.log("Status code : " + resp.statusCode());
			assertTrue(false);
		}

		}
	
	public HashMap<String, Object> headersForTripservicepostcall(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "application/json");
		return headers;

	}

}
