package test.java.tripServices;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TS_Fetch_Useridbytripref extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void fetchuseridbytripref() throws Exception{
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/userId-by-tripRef/Q230803766448");
	String url="http://trip-service-api.cltp.com:9001/trips/userId-by-tripRef/Q230803766448";
	Response resp=RestAssured.get(url);
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
}
 }
