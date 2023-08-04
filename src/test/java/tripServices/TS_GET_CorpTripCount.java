package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_GET_CorpTripCount extends TripserviceCommon {
	
	@Test(groups={"Regression"})
	public void getCorpTripCount() throws IOException, InterruptedException{
		Reporter.log("http://trip-service-api.cltp.com:9001/api/trips?airline-pnr=NZSILX");
		Response resp=RestAssured.get("http://trip-service-api.cltp.com:9001/api/trips?airline-pnr=NZSILX");
		System.out.println(resp.asString());
		if(resp.statusCode()==200){
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://trip-service-api.cltp.com:9001/api/trips?domain=automationqa2pta.cleartripforbusiness.com");
		Response resp1=RestAssured.get("http://trip-service-api.cltp.com:9001/api/trips?domain=automationqa2pta.cleartripforbusiness.com");
		System.out.println(resp1.asString());
		if(resp1.statusCode()==200){
			ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp1.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://trip-service-api.cltp.com:9001/api/trips?domain=automationqa2pta.cleartripforbusiness.com&booking-status=P&status-history=4128");
		Response resp2=RestAssured.get("http://trip-service-api.cltp.com:9001/api/trips?domain=automationqa2pta.cleartripforbusiness.com&booking-status=P&status-history=4128");
		System.out.println(resp2.asString());
		if(resp2.statusCode()==200){
			ResponseBody body= resp2.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp2.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://trip-service-api.cltp.com:9001/api/trips?domain=automationqa2pta.cleartripforbusiness.com&airline-pnr=VXZVKS&booking-status=P&status-history=4128&gds-pnr=5T6N3M&txn-status=C&booker-id=4172698&pax-id=55370546");
		Response resp3=RestAssured.get("http://trip-service-api.cltp.com:9001/api/trips?domain=automationqa2pta.cleartripforbusiness.com&airline-pnr=VXZVKS&booking-status=P&status-history=4128&gds-pnr=5T6N3M&txn-status=C&booker-id=4172698&pax-id=55370546");
		System.out.println(resp3.asString());
		if(resp3.statusCode()==200){
			ResponseBody body= resp3.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp3.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://trip-service-api.cltp.com:9001/api/trips?domain=automationqa2pta.cleartripforbusiness.com&booker-id=4172698");
		Response resp4=RestAssured.get("http://trip-service-api.cltp.com:9001/api/trips?domain=automationqa2pta.cleartripforbusiness.com&booker-id=4172698");
		System.out.println(resp4.asString());
		if(resp4.statusCode()==200){
			ResponseBody body= resp3.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Reporter.log(bodyAsString);
		}else {
			Reporter.log("Status code : " + resp4.statusCode());
			assertTrue(false);
		}
	}

}
