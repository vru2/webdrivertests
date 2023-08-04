package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_GET_Air_Refunded extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void getAirRefunded() throws Exception{
	String Host = common.value("host");
	Reporter.log("Fetching from realtime db");
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/air/refunded?status=D&fromDate=2019-10-29&toDate=2019-12-03&dbFetchType=REAL_TIME");
	Response resp=RestAssured.get("http://trip-service-api.cltp.com:9001/trips/air/refunded?status=D&fromDate=2019-10-29&toDate=2019-12-03&dbFetchType=REAL_TIME");
	System.out.println(resp.asString());
	if(resp.statusCode()==200){
		ResponseBody body= resp.getBody();
		String bodyAsString = body.asString();
		Assert.assertNotNull(resp);
		Reporter.log(bodyAsString);
	}else{
		Reporter.log("Status code : " + resp.statusCode());
		assertTrue(false);
	}
	}
	
}

