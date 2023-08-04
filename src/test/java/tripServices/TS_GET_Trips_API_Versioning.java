package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_GET_Trips_API_Versioning extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void getTripService(){
		Reporter.log("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=true&apiVersion=V1");
		Response resp=RestAssured.get("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=true&apiVersion=V1");
		System.out.println(resp.asString());
		if(resp.statusCode()==200){
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertEquals(bodyAsString.contains("payment_type"), true ,"Response boday contains payment_type");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=false&apiVersion=V1");
		Response resp1=RestAssured.get("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=false&apiVersion=V1");
		System.out.println(resp1.asString());
		if(resp1.statusCode()==200){
			ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertNotNull("payments");
			Assert.assertNotNull("payment_type");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp1.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=true&apiVersion=V2");
		Response resp2=RestAssured.get("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=true&apiVersion=V2");
		System.out.println(resp2.asString());
		if(resp2.statusCode()==200){
			ResponseBody body= resp2.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertEquals(bodyAsString.contains("payment_type"), true ,"Response boday contains payment_type");
			Assert.assertEquals(bodyAsString.contains("ct_for_work"), true ,"Response boday contains ct_for_work");
			Assert.assertEquals(bodyAsString.contains("emails"), true ,"Response boday contains emails");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp2.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=false&apiVersion=V2");
		Response resp3=RestAssured.get("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=false&apiVersion=V2");
		System.out.println(resp3.asString());
		if(resp3.statusCode()==200){
			ResponseBody body= resp3.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertNotNull("payments");
			Assert.assertNotNull("payment_type");
			Assert.assertEquals(bodyAsString.contains("ct_for_work"), true ,"Response boday contains ct_for_work");
			Assert.assertEquals(bodyAsString.contains("emails"), true ,"Response boday contains emails");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp3.statusCode());
			assertTrue(false);
		}
		
		Reporter.log("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=true&apiVersion=V3");
		Response resp4=RestAssured.get("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=true&apiVersion=V3");
		System.out.println(resp4.asString());
		if(resp4.statusCode()==200){
			ResponseBody body= resp4.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertEquals(bodyAsString.contains("payments_service_data"), true ,"Response boday contains payments_service_data");
			Assert.assertEquals(bodyAsString.contains("payment_type"), true ,"Response boday contains payment_type");
			Assert.assertNotNull("reward_points_txns");
			Assert.assertEquals(bodyAsString.contains("transaction_type"), true ,"Response boday contains transaction_type");
			Assert.assertEquals(bodyAsString.contains("reward_points_txn_details"), true ,"Response boday contains reward_points_txn_details");
			Assert.assertEquals(bodyAsString.contains("ct_for_work"), true ,"Response boday contains ct_for_work");
			Assert.assertEquals(bodyAsString.contains("emails"), true ,"Response boday contains emails");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp4.statusCode());
			assertTrue(false);
		}
		
		Reporter.log("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=false&apiVersion=V3");
		Response resp5=RestAssured.get("http://trip-service-api.cltp.com:9001/trips?tripID=Q190903480280&refundRequired=true&historyRequired=true&paymentsRequired=false&apiVersion=V3");
		System.out.println(resp5.asString());
		if(resp5.statusCode()==200){
			ResponseBody body= resp5.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertNotNull("payments");
			Assert.assertNotNull("payment_type");
			Assert.assertEquals(bodyAsString.contains("ct_for_work"), true ,"Response boday contains ct_for_work");
			Assert.assertEquals(bodyAsString.contains("emails"), true ,"Response boday contains emails");
			Reporter.log(bodyAsString);
		}else {
			Reporter.log("Status code : " + resp5.statusCode());
			assertTrue(false);
		}
	}


}
