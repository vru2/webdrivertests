package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_Get_RefundInfo extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void refundinfo() throws Exception{
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/Q21061572422/get_refund_info?txn_id=76012482&apiVersion=V1");
	Response resp=RestAssured.get("http://trip-service-api.cltp.com:9001/trips/Q21061572422/get_refund_info?txn_id=76012482&apiVersion=V1");
	System.out.println(resp.asString());
	if(resp.statusCode()==200){
		ResponseBody body= resp.getBody();
		String bodyAsString = body.asString();
		Assert.assertNotNull(resp);
		 Assert.assertEquals("Response consists cancelled_time field",bodyAsString.contentEquals("cancelled_time"), bodyAsString.contentEquals("cancelled_time"));
		 Assert.assertEquals("Response consists booking_info_id field",bodyAsString.contentEquals("booking_info_id"), bodyAsString.contentEquals("booking_info_id"));	
		 Assert.assertEquals("Response consists pax_info field",bodyAsString.contentEquals("pax_info"), bodyAsString.contentEquals("pax_info"));	
		 Assert.assertEquals("Response consists sector field",bodyAsString.contentEquals("sector"), bodyAsString.contentEquals("sector"));	
		 Assert.assertEquals("Response consists booking_status field",bodyAsString.contentEquals("booking_status"), bodyAsString.contentEquals("booking_status"));	
		 Assert.assertEquals("Response consists refund_amount field",bodyAsString.contentEquals("refund_amount"), bodyAsString.contentEquals("refund_amount"));	
		 Assert.assertEquals("Response consists apiwallet_refund_amount field",bodyAsString.contentEquals("apiwallet_refund_amount"), bodyAsString.contentEquals("apiwallet_refund_amount"));			
		 
		 Reporter.log(bodyAsString);
	}else{
		Reporter.log("Status code : " + resp.statusCode());
		assertTrue(false);
	}
	Reporter.log("http://trip-service-api.cltp.com:9001/trips/Q21061572422/get_refund_info?txn_id=76012482&apiVersion=V3");
	Response resp1=RestAssured.get("http://trip-service-api.cltp.com:9001/trips/Q21061572422/get_refund_info?txn_id=76012482&apiVersion=V3");
	System.out.println(resp1.asString());
	if(resp1.statusCode()==200){
		ResponseBody body= resp1.getBody();
		String bodyAsString = body.asString();
		Assert.assertNotNull(resp1);
		 Assert.assertEquals("Response consists cancelled_time field",bodyAsString.contentEquals("cancelled_time"), bodyAsString.contentEquals("cancelled_time"));
		 Assert.assertEquals("Response consists booking_info_id field",bodyAsString.contentEquals("booking_info_id"), bodyAsString.contentEquals("booking_info_id"));	
		 Assert.assertEquals("Response consists pax_info field",bodyAsString.contentEquals("pax_info"), bodyAsString.contentEquals("pax_info"));	
		 Assert.assertEquals("Response consists sector field",bodyAsString.contentEquals("sector"), bodyAsString.contentEquals("sector"));	
		 Assert.assertEquals("Response consists booking_status field",bodyAsString.contentEquals("booking_status"), bodyAsString.contentEquals("booking_status"));	
		 Assert.assertEquals("Response consists refund_amount field",bodyAsString.contentEquals("refund_amount"), bodyAsString.contentEquals("refund_amount"));	
		 Assert.assertEquals("Response consists apiwallet_refund_amount field",bodyAsString.contentEquals("apiwallet_refund_amount"), bodyAsString.contentEquals("apiwallet_refund_amount"));			
		 Assert.assertEquals("Response consists supplier_charge field",bodyAsString.contentEquals("supplier_charge"), bodyAsString.contentEquals("supplier_charge"));			
		 Assert.assertEquals("Response consists conveniencefee_refund field",bodyAsString.contentEquals("conveniencefee_refund"), bodyAsString.contentEquals("conveniencefee_refund"));			
		 
		 Reporter.log(bodyAsString);
	}else{
		Reporter.log("Status code : " + resp1.statusCode());
		assertTrue(false);
	}
}
 }
