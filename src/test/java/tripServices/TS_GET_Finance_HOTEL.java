package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_GET_Finance_HOTEL extends TripserviceCommon {
		@Test(groups={"Regression"})
		public void getTripService() throws IOException, InterruptedException {
			String url="http://trip-service-api.cltp.com:9001/trips/finance?fromDate=2023-06-01&toDate=2023-07-01&productType=hotel&txnType=1&paymentStatus=SUCCESS&domains=cleartrip.com%24";
			Reporter.log(url);
			Response resp=RestAssured.get(url);
			Thread.sleep(6000);
			System.out.println(resp.asString());
			if(resp.statusCode()==200){
				ResponseBody body= resp.getBody();
				String bodyAsString = body.asString();
				Reporter.log(bodyAsString);
				Assert.assertEquals(resp.statusCode(),200,"Correct status code displayed");
			}else{
				Reporter.log("Status code : " + resp.statusCode());
				assertTrue(false);
			}
		}
		
}	

