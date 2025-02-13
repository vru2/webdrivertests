package test.java.  tripServicesProd;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_GET_FinanceAllTrips_Local extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void getTripService() throws IOException{
		String url="http://172.21.48.21:9031/trips/finance/all-trips?date=2019-08-01&productType=local&txnType=1&paymentStatus=SUCCESS&domains=cleartrip.com%24&excludedDomains=cleartrip.ae%5E%24";
		Response resp=RestAssured.get(url);
		if(resp.statusCode()==200){
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Reporter.log(bodyAsString);
			Assert.assertEquals(resp.statusCode(),200,"Correct status code dispalayed");
		}else{
			Reporter.log("Status code : " + resp.statusCode());
			assertTrue(false);
		}
	}


}
