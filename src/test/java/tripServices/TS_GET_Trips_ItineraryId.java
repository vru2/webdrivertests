package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_GET_Trips_ItineraryId extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void getTripsbyItineraryId() throws IOException{
		String url=Service_Url("TRIPSERVICE_GETTRIPS_ITINERARYID");
		Reporter.log(url);
		
		Response resp=RestAssured.get(url);
		System.out.println(url);
		System.out.println(resp.asString());
		if(resp.statusCode()==200){
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains tripId");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp.statusCode());
			assertTrue(false);
		}
		
	}
	
}
