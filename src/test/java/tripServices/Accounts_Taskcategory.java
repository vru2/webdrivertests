package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Accounts_Taskcategory extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void Accounts_Taskcategory() throws Exception{
		Response resp;
		Response resp1;
		String url_qa="http://trip-service-api.cltp.com:9001/api/trips/task-category?id=5159615";
		String url1_qa="http://trip-service-api.cltp.com:9001/api/trips/task-category?companyId=140329";
		Reporter.log(url_qa);
	    resp=RestAssured.get(url_qa);
	    if(resp.statusCode()==200){
	    	Reporter.log(resp.asString());
	    	System.out.println(resp.asString());
	    	Reporter.log("Status code " + resp.statusCode());
	    	ResponseBody body= resp.getBody();
	    	 String bodyAsString = body.asString();
			    Reporter.log("Status code " + resp.statusCode());
				Assert.assertNotNull("id");
				Assert.assertNotNull("company_id");
				Assert.assertNotNull("category");
				Assert.assertNotNull("person_id");
				Assert.assertEquals(bodyAsString.contains("Hotel Bookings"), true ,"Response boday contains Hotel Bookings");
			
	    }else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
	    Reporter.log(url1_qa);
	    resp1=RestAssured.get(url1_qa);
	    if(resp1.statusCode()==200){
	    	Reporter.log(resp1.asString());
			System.out.println(resp1.asString());
	    	Reporter.log("Status code " + resp1.statusCode());
	    	ResponseBody body= resp1.getBody();
		    String bodyAsString = body.asString();
		    Reporter.log("Status code " + resp1.statusCode());
			Assert.assertNotNull("id");
			Assert.assertNotNull("company_id");
			Assert.assertNotNull("category");
			Assert.assertEquals(bodyAsString.contains("Book"), true ,"Response boday contains Book");
			Assert.assertEquals(bodyAsString.contains("Call"), true ,"Response boday contains Call");
			Assert.assertEquals(bodyAsString.contains("Cancel"), true ,"Response boday contains Cancel");
			Assert.assertEquals(bodyAsString.contains("Payment"), true ,"Response boday contains Payment");
			Assert.assertEquals(bodyAsString.contains("Refund"), true ,"Response boday contains Refund");
			Assert.assertEquals(bodyAsString.contains("Web Check In"), true ,"Response boday contains Web Check In");
			
			
	    }else{
			Reporter.log("Status code " + resp1.statusCode());
			assertTrue(false);
		}
   }	
}
