package test.java.tripServices;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TS_Fetch_BookingStatus extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void fetchBookingstatus() throws Exception{
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/fetch-booking-status?tripRef=Q230803766316");
	Response resp=RestAssured.get("http://trip-service-api.cltp.com:9001/trips/fetch-booking-status?tripRef=Q230803766316");
	System.out.println(resp.asString());
	if(resp.statusCode()==200){
		ResponseBody body= resp.getBody();
		String bodyAsString = body.asString();
		Assert.assertNotNull(resp);
		 Assert.assertEquals("Booking status is P",bodyAsString.contentEquals("P"), bodyAsString.contentEquals("P"));
		Reporter.log(bodyAsString);
	}else{
		Reporter.log("Status code : " + resp.statusCode());
		assertTrue(false);
	}
}
 }
