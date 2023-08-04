package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_Coupon_Validation extends TripserviceCommon{
	
	@Test(groups={"Regression"})
	public void couponValidation() throws IOException, InterruptedException{
		Reporter.log("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=DOMOW&count=1&usageCountRequired=false");
		Response resp=RestAssured.get("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=DOMOW&count=1&usageCountRequired=false");
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
		Reporter.log("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=WALLET3,DOMOW&count=1&usageCountRequired=false");
		Response resp1=RestAssured.get("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=WALLET3,DOMOW&count=1&usageCountRequired=false");
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
		Reporter.log("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=DOMOW&count=1756&usageCountRequired=false");
		Response resp2=RestAssured.get("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=DOMOW&count=1756&usageCountRequired=false");
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
		Reporter.log("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=WALLET3&count=1&usageCountRequired=true");
		Response resp3=RestAssured.get("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=WALLET3&count=1&usageCountRequired=true");
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
		Reporter.log("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=WALLET3,DOMOW&count=1&usageCountRequired=true");
		Response resp4=RestAssured.get("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=WALLET3,DOMOW&count=1&usageCountRequired=true");
		System.out.println(resp4.asString());
		if(resp4.statusCode()==200){
			ResponseBody body= resp4.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp4.statusCode());
			assertTrue(false);
		}
		
		Reporter.log("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=WALLET3,DOMOW&count=354&usageCountRequired=true");
		Response resp5=RestAssured.get("http://trip-service-api.cltp.com:9001/commonservice/trips/coupons/validation?couponCodes=WALLET3,DOMOW&count=354&usageCountRequired=true");
		System.out.println(resp5.asString());
		if(resp5.statusCode()==200){
			ResponseBody body= resp5.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp5.statusCode());
			assertTrue(false);
		}
	
		}

}
