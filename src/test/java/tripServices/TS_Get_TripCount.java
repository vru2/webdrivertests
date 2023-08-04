package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_Get_TripCount extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void tripcount() throws Exception{
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/trip-count?product=train&railway-pnr-exists=true&booking-date-from=2021-03-01&user-id=65186377");
	Response resp=RestAssured.get("http://trip-service-api.cltp.com:9001/trips/trip-count?product=train&railway-pnr-exists=true&booking-date-from=2021-03-01&user-id=65186377");
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
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/trip-count?product=train&railway-pnr-exists=false&booking-date-from=2021-03-01&user-id=65186377");
	Response resp1=RestAssured.get("http://trip-service-api.cltp.com:9001/trips/trip-count?product=train&railway-pnr-exists=false&booking-date-from=2021-03-01&user-id=65186377");
	System.out.println(resp1.asString());
	if(resp1.statusCode()==200){
		ResponseBody body= resp.getBody();
		String bodyAsString = body.asString();
		Assert.assertNotNull(resp1);
		Reporter.log(bodyAsString);
	}else{
		Reporter.log("Status code : " + resp1.statusCode());
		assertTrue(false);
	}
}
 }
