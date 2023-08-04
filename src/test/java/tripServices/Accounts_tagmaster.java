package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Accounts_tagmaster extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void Accounts_ExistingUsers() throws Exception{
		Response resp;
		Response resp1;
		Response resp2;
		Response resp3;
		String url="http://trip-service-api.cltp.com:9001/api/trips/tag-master?tagMasterId=233256236";
		String url1="http://trip-service-api.cltp.com:9001/api/trips/tag-master?tagMasterId=233166322";
		String url2="http://trip-service-api.cltp.com:9001/api/trips/tag-master?tagMasterId=233226280";
		String url3="http://trip-service-api.cltp.com:9001/api/trips/tag-master?tagMasterId=233266298";
		Reporter.log(url);
	    resp=RestAssured.get(url);
	    if(resp.statusCode()==200){
	    	Reporter.log(resp.asString());
	    	System.out.println(resp.asString());
		    Reporter.log("Status code " + resp.statusCode());
		    ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("Coupon:CTRT5850448"), true ,"Response boday contains Coupon:CTRT5850448");
			Assert.assertEquals(bodyAsString.contains("SYNC"), true ,"Response boday contains SYNC");
			Assert.assertNotNull("tag_name");
			Assert.assertNotNull("source_type");
			Assert.assertNotNull("id");
			Assert.assertNotNull("user_id");
			Assert.assertNotNull("coupon_expiry_date");
			
	    }else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
	    
	    Reporter.log(url1);
	    resp1=RestAssured.get(url1);
	    if(resp1.statusCode()==200){
	    	Reporter.log(resp1.asString());
	    	System.out.println(resp1.asString());
		    Reporter.log("Status code " + resp1.statusCode());
		    ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("101-thanospart1"), true ,"Response boday contains 101-thanospart1");
			Assert.assertEquals(bodyAsString.contains("blackcat"), true ,"Response boday contains blackcat");
			Assert.assertEquals(bodyAsString.contains("CORP"), true ,"Response boday contains CORP");
			Assert.assertEquals(bodyAsString.contains("Company"), true ,"Response boday contains Company");
			Assert.assertNotNull("tag_name");
			Assert.assertNotNull("tag_description");
			Assert.assertNotNull("source_type");
			Assert.assertNotNull("id");
			Assert.assertNotNull("status");	
			Assert.assertNotNull("tag_links");
			Assert.assertNotNull("tag_id");
			Assert.assertNotNull("tag_master_id");
			Assert.assertNotNull("tag_type");
	    }else{
			Reporter.log("Status code " + resp1.statusCode());
			assertTrue(false);
		}
	    Reporter.log(url2);
	    resp2=RestAssured.get(url2);
	    if(resp2.statusCode()==200){
	    	Reporter.log(resp2.asString());
	    	System.out.println(resp2.asString());
		    Reporter.log("Status code " + resp2.statusCode());
		    ResponseBody body= resp2.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("test tag 2"), true ,"Response boday contains test tag 2");
			Assert.assertEquals(bodyAsString.contains("test 2"), true ,"Response boday contains test 2");
			Assert.assertEquals(bodyAsString.contains("HQ"), true ,"Response boday contains HQ");
			Assert.assertEquals(bodyAsString.contains("Company"), true ,"Response boday contains Company");
			Assert.assertNotNull("tag_name");
			Assert.assertNotNull("tag_description");
			Assert.assertNotNull("source_type");
			Assert.assertNotNull("id");
			Assert.assertNotNull("status");		
			Assert.assertNotNull("tag_links");
			Assert.assertNotNull("tag_id");
			Assert.assertNotNull("tag_master_id");
			Assert.assertNotNull("tag_type");
	    }else{
			Reporter.log("Status code " + resp2.statusCode());
			assertTrue(false);
		}
	    Reporter.log(url3);
	    resp3=RestAssured.get(url3);
	    if(resp3.statusCode()==200){
	    	Reporter.log(resp3.asString());
	    	System.out.println(resp3.asString());
		    Reporter.log("Status code " + resp3.statusCode());
		    ResponseBody body= resp3.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("Coupon:sassaaaaa"), true ,"Response boday contains Coupon:sassaaaaa");
			Assert.assertEquals(bodyAsString.contains("COMPANY"), true ,"Response boday contains COMPANY");
			Assert.assertEquals(bodyAsString.contains("Company"), true ,"Response boday contains Company");
			Assert.assertNotNull("tag_name");
			Assert.assertNotNull("source_type");
			Assert.assertNotNull("id");
			Assert.assertNotNull("status");	
			Assert.assertNotNull("tag_links");
			Assert.assertNotNull("tag_id");
			Assert.assertNotNull("tag_master_id");
			Assert.assertNotNull("tag_type");
	    }else{
			Reporter.log("Status code " + resp3.statusCode());
			assertTrue(false);
		}
	    
}
}
