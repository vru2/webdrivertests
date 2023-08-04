package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_Fetch_PeopleDetails extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void peopledetails() throws Exception{
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/46812466/fetch-people-details");
	Response resp=RestAssured.get("http://trip-service-api.cltp.com:9001/trips/46812466/fetch-people-details");
	System.out.println(resp.asString());
	if(resp.statusCode()==200){
		ResponseBody body= resp.getBody();
		String bodyAsString = body.asString();
		Assert.assertNotNull(resp);
		 Assert.assertEquals("user_name is varalakshmi.venkateshaiah@cleartrip.com",bodyAsString.contentEquals("varalakshmi.venkateshaiah@cleartrip.com"), bodyAsString.contentEquals("varalakshmi.venkateshaiah@cleartrip.com"));	
		 Assert.assertEquals("Response consists user_id field",bodyAsString.contentEquals("user_id"), bodyAsString.contentEquals("user_id"));
		 Assert.assertEquals("Response consists user_name field",bodyAsString.contentEquals("user_name"), bodyAsString.contentEquals("user_name"));	
		Reporter.log(bodyAsString);
	}else{
		Reporter.log("Status code : " + resp.statusCode());
		assertTrue(false);
	}
}
 }
