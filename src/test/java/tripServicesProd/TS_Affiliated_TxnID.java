package test.java.  tripServicesProd;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_Affiliated_TxnID extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void getTripService(){
		Reporter.log("http://trip-service.cltp.com:9001/trips/affiliate-txn-id?affiliateTxnId=1");
		Response resp=RestAssured.get("http://trip-service.cltp.com:9001/trips/affiliate-txn-id?affiliateTxnId=1");
		if(resp.statusCode()==200){
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains tripId");
			Reporter.log(bodyAsString);
			System.out.println(resp.asString());
		}else{
			Reporter.log("Status code : " + resp.statusCode());
			assertTrue(false);
		}
	}

}
