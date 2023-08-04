package test.java.tripServices;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class TS_Fetch_TripRefByBookingStatus extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void fetchBookingstatus() throws Exception{
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/tripRef-by-bookingStatus?bookingStatus=P&fromDate=2023-08-01&toDate=2023-08-03");
	// Air
	Response resp=RestAssured.given().
			when().
			log().all().
			headers("product-type","AIR").get("http://trip-service-api.cltp.com:9001/trips/tripRef-by-bookingStatus?bookingStatus=P&fromDate=2023-08-01&toDate=2023-08-03");
	System.out.println(resp.asString());
	if(resp.statusCode()==200){
		ResponseBody body= resp.getBody();
		String bodyAsString = body.asString();
		Assert.assertNotNull(resp);
		Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains  trip_ref");
	    Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains  booking_status");
		Assert.assertEquals(bodyAsString.contains("P"), true ,"Response boday contains  booking_status P");
		Reporter.log(bodyAsString);
	}else{
		Reporter.log("Status code : " + resp.statusCode());
		assertTrue(false);
	}

	// Hotel
		Response resp1=RestAssured.given().
				when().
				log().all().
				headers("product-type","HOTEL").get("http://trip-service-api.cltp.com:9001/trips/tripRef-by-bookingStatus?bookingStatus=P&fromDate=2023-08-01&toDate=2023-08-03");
		System.out.println(resp1.asString());
		if(resp1.statusCode()==200){
			ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(resp1);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains  trip_ref");
			Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains  booking_status");
			Assert.assertEquals(bodyAsString.contains("P"), true ,"Response boday contains  booking_status P");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp1.statusCode());
			assertTrue(false);
		}

		// Bus
		Response resp2=RestAssured.given().
				when().
				log().all().
				headers("product-type","AIR").get("http://trip-service-api.cltp.com:9001/trips/tripRef-by-bookingStatus?bookingStatus=P&fromDate=2023-08-01&toDate=2023-08-03");
		System.out.println(resp2.asString());
		if(resp2.statusCode()==200){
			ResponseBody body= resp2.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(resp2);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains  trip_ref");
			Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains  booking_status");
			Assert.assertEquals(bodyAsString.contains("P"), true ,"Response boday contains  booking_status P");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp2.statusCode());
			assertTrue(false);
		}
}
 }
