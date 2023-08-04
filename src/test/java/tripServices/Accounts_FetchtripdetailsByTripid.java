package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Accounts_FetchtripdetailsByTripid extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void Accounts_FetchByTripid() throws Exception{
		Response resp;
		Response resp1;
		Response resp2;
		Response resp3;
		String url_air=" http://trip-service-api.cltp.com:9001/api/trips/fetch-trip-details?tripId=46201038&size=1";
		String url_hotel="http://trip-service-api.cltp.com:9001/api/trips/fetch-trip-details?tripId=46202808&size=1";
		String url_local="http://trip-service-api.cltp.com:9001/api/trips/fetch-trip-details?tripId=46089500&size=1";
		String url_train="http://trip-service-api.cltp.com:9001/api/trips/fetch-trip-details?tripId=45967650&size=1";
			Reporter.log(url_air);
	    resp=RestAssured.get(url_air);
	    if(resp.statusCode()==200){
	    	Reporter.log(resp.asString());
	    	System.out.println(resp.asString());
		    Reporter.log("Status code " + resp.statusCode());
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_id"), true ,"Response boday contains trip_id");
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
            Assert.assertNotNull("air_bookings");
	    }else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
	    Thread.sleep(2000);
	    Reporter.log(url_hotel);
	    resp1=RestAssured.get(url_hotel);
	    if(resp1.statusCode()==200){
	    	Reporter.log(resp1.asString());
	    	System.out.println(resp1.asString());
		    Reporter.log("Status code " + resp1.statusCode());
			ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_id"), true ,"Response boday contains trip_id");
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
            Assert.assertNotNull("hotel_bookings");
	    }else{
			Reporter.log("Status code " + resp1.statusCode());
			assertTrue(false);
		}
		
		 Thread.sleep(2000);
		    Reporter.log(url_local);
		    resp2=RestAssured.get(url_local);
		    if(resp2.statusCode()==200){
		    	Reporter.log(resp2.asString());
		    	System.out.println(resp2.asString());
			    Reporter.log("Status code " + resp2.statusCode());
				ResponseBody body= resp2.getBody();
				String bodyAsString = body.asString();
				Assert.assertEquals(bodyAsString.contains("trip_id"), true ,"Response boday contains trip_id");
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
	            Assert.assertNotNull("activity_bookings");
		    }else{
				Reporter.log("Status code " + resp2.statusCode());
				assertTrue(false);
			}
	 Thread.sleep(2000);
	    Reporter.log(url_train);
	    resp3=RestAssured.get(url_train);
	    if(resp3.statusCode()==200){
	    	Reporter.log(resp3.asString());
	    		System.out.println(resp3.asString());
		    Reporter.log("Status code " + resp3.statusCode());
			ResponseBody body= resp3.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_id"), true ,"Response boday contains trip_id");
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
         Assert.assertNotNull("train_bookings");
	    }else{
			Reporter.log("Status code " + resp3.statusCode());
			assertTrue(false);
		}
		}
	}
