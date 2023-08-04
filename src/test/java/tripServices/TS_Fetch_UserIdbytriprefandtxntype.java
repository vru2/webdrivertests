package test.java.tripServices;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TS_Fetch_UserIdbytriprefandtxntype extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void fetchuserid() throws Exception{
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/txn/userId/47337016?txnType=1");
	String url="http://trip-service-api.cltp.com:9001/trips/txn/userId/47337016?txnType=1";
	Response resp=RestAssured.get(url);
	System.out.println(resp.asString());
	if(resp.statusCode()==200){
		ResponseBody body= resp.getBody();
		String bodyAsString = body.asString();
		Assert.assertNotNull(resp);
		Assert.assertEquals(bodyAsString.contains("userId"), true ,"Response boday contains  userId");
	   Reporter.log(bodyAsString);
	}else{
		Reporter.log("Status code : " + resp.statusCode());
		assertTrue(false);
	}
}
 }
