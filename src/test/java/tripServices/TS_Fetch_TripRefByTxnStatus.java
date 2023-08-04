package test.java.tripServices;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TS_Fetch_TripRefByTxnStatus extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void fetchtripref() throws Exception{
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/tripRef-by-txnStatus?productType=bus&fromDate=2023-08-01 00:00:00&toDate=2023-08-05 00:00:00");
		String url="http://trip-service-api.cltp.com:9001/trips/tripRef-by-txnStatus?productType=bus&fromDate=2023-08-01 00:00:00&toDate=2023-08-05 00:00:00";
	Response resp=RestAssured.get(url);
	System.out.println(resp.asString());
	if(resp.statusCode()==200){
		ResponseBody body= resp.getBody();
		String bodyAsString = body.asString();
		Assert.assertNotNull(resp);
		Assert.assertEquals(bodyAsString.contains("tripRefs"), true ,"Response boday contains  tripRefs");
	   Reporter.log(bodyAsString);
	}else{
		Reporter.log("Status code : " + resp.statusCode());
		assertTrue(false);
	}
}
 }
