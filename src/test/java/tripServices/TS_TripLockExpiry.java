package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_TripLockExpiry extends TripserviceCommon {
	
	@Test(groups={"Regression"})
	public void Trip_LockExpiry() throws Exception{
		
		Response resp;
		String url="http://trip-service-api.cltp.com:9001/trips/delay-lock-expiry/Q191218623804/200";
		String prod="http://trip-service.cltp.com:9001/trips/delay-lock-expiry/191218163562/200";
		System.out.println(url);
		Reporter.log(url);
		resp=RestAssured.given().
					when().
					log().all().
					headers("Accept", "application/json").
					headers("Content-Type","application/json").
					post(url);
	      if(resp.statusCode()==200){
	    	System.out.println(resp.asString());
	    	Reporter.log(resp.asString());
		    Reporter.log("Status code " + resp.statusCode());
		    ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertEquals(bodyAsString.contains("lock_owner"), true ,"Response boday contains lock_owner");
			Assert.assertNotNull("trip_ref");
			Assert.assertNotNull("lock_owner");
			Assert.assertNotNull("lock_time");
			Assert.assertNotNull("expiry_time");
	    }
	    else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
	    }


}
