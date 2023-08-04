package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Accounts_CreateUpdate_Tagmaster extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void Accounts_ExistingUsers() throws Exception{
		Response resp;
		Response resp1;
		String url="http://trip-service-api.cltp.com:9001/api/trips/company-tag";
		String s=RandomStringUtils.randomNumeric(4);
		String params="{\"tags\":[{\"tag_name\":\"testcorpautomation"+s+"tags\",\"tag_description\":\"tester\",\"created_at\":\"2019-11-06T15:34:13.544+0530\",\"updated_at\":\"2019-11-06T15:34:13.544+0530\",\"source_type\":\"CORP\",\"rule_id\":null,\"status\":\"A\",\"created_by\":\"65182099\",\"updated_by\":\"65182099\",\"user_id\":\"41695398\",\"coupon_expiry_date\":null,\"coupon_type\":null,\"parent_id\":null},{\"tag_name\":\"testerhqautomation"+s+"tag\",\"tag_description\":\"tester 2\",\"created_at\":\"2019-11-06T15:34:13.571+0530\",\"updated_at\":\"2019-11-06T15:34:13.571+0530\",\"source_type\":\"HQ\",\"rule_id\":null,\"status\":\"A\",\"created_by\":\"65182099\",\"updated_by\":\"65182099\",\"user_id\":\"41695398\",\"coupon_expiry_date\":null,\"coupon_type\":null,\"parent_id\":null},{\"tag_name\":\"Coupon:Automation"+s+"\",\"tag_description\":\"tester 2\",\"created_at\":\"2019-11-06T15:34:13.604+0530\",\"updated_at\":\"2019-11-06T15:34:13.604+0530\",\"source_type\":\"SYNC\",\"rule_id\":null,\"status\":null,\"created_by\":\"65182099\",\"updated_by\":\"65182099\",\"user_id\":\"41695398\",\"coupon_expiry_date\":\"2019-11-30\",\"coupon_type\":null,\"parent_id\":null}],\"tag_type\":\"Company\",\"reference_id\":1234}";
		String triptag="{\"tags\":[{\"tag_name\":\"testautomationtrip"+s+"tags\",\"tag_description\":\"tester\",\"created_at\":\"2019-11-06T15:34:13.544+0530\",\"updated_at\":\"2019-11-06T15:34:13.544+0530\",\"source_type\":\"CORP\",\"rule_id\":null,\"status\":\"A\",\"created_by\":\"65182099\",\"updated_by\":\"65182099\",\"user_id\":\"41695398\",\"coupon_expiry_date\":null,\"coupon_type\":null,\"parent_id\":null}],\"tag_type\":\"Trip\",\"reference_id\":47306410}";
		String Host = common.value("host");
			Reporter.log(url);
	    resp=RestAssured.given().
				when().
				log().all().
				body(params).
				headers("Content-Type", "application/json").
				post(url);
	    	System.out.println(resp.asString());	
	    if(resp.statusCode()==200){
	    	Reporter.log(resp.asString());
		    Reporter.log("Status code " + resp.statusCode());
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("id"), true ,"Response boday contains id");
			Assert.assertNotNull("id");
			Assert.assertEquals(bodyAsString.contains("tag_name"), true ,"Response boday contains tag_name");
			Assert.assertNotNull("tag_name");
			Assert.assertEquals(bodyAsString.contains("created_by"), true ,"Response boday contains created_by");
			Assert.assertNotNull("created_by");
			Assert.assertEquals(bodyAsString.contains("updated_by"), true ,"Response boday contains updated_by");
			Assert.assertNotNull("updated_by");
			Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
			Assert.assertNotNull("user_id");
			Assert.assertEquals(bodyAsString.contains("tag_description"), true ,"Response boday contains tag_description");
			Assert.assertNotNull("tag_description");
			Assert.assertEquals(bodyAsString.contains("coupon_expiry_date"), true ,"Response boday contains coupon_expiry_date");
			Assert.assertNotNull("tag_links");
			Assert.assertEquals(bodyAsString.contains("tag_links"), true ,"Response boday contains tag_links");
			Assert.assertEquals(bodyAsString.contains("tag_id"), true ,"Response boday contains tag_id");
			Assert.assertEquals(bodyAsString.contains("tag_master_id"), true ,"Response boday contains tag_master_id");
			Assert.assertEquals(bodyAsString.contains("tag_type"), true ,"Response boday contains tag_type");
			Assert.assertEquals(bodyAsString.contains("Company"), true ,"Response boday contains Company");
	   
	    }else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
	    
	    resp1=RestAssured.given().
				when().
				log().all().
				body(triptag).
				headers("Content-Type", "application/json").
				post(url);
	    System.out.println(resp1.asString());
	    if(resp1.statusCode()==200){
	    	Reporter.log(resp1.asString());
	    	Reporter.log(resp1.asString());
		    Reporter.log("Status code " + resp1.statusCode());
		    
			ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("id"), true ,"Response boday contains id");
			Assert.assertNotNull("id");
			Assert.assertEquals(bodyAsString.contains("tag_name"), true ,"Response boday contains tag_name");
			Assert.assertNotNull("tag_name");
			Assert.assertEquals(bodyAsString.contains("created_by"), true ,"Response boday contains created_by");
			Assert.assertNotNull("created_by");
			Assert.assertEquals(bodyAsString.contains("updated_by"), true ,"Response boday contains updated_by");
			Assert.assertNotNull("updated_by");
			Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
			Assert.assertNotNull("user_id");
			Assert.assertEquals(bodyAsString.contains("tag_description"), true ,"Response boday contains tag_description");
			Assert.assertNotNull("tag_description");
			Assert.assertEquals(bodyAsString.contains("coupon_expiry_date"), true ,"Response boday contains coupon_expiry_date");
			Assert.assertNotNull("tag_links");
			Assert.assertEquals(bodyAsString.contains("tag_links"), true ,"Response boday contains tag_links");
			Assert.assertEquals(bodyAsString.contains("tag_id"), true ,"Response boday contains tag_id");
			Assert.assertEquals(bodyAsString.contains("tag_master_id"), true ,"Response boday contains tag_master_id");
			Assert.assertEquals(bodyAsString.contains("tag_type"), true ,"Response boday contains tag_type");
			Assert.assertEquals(bodyAsString.contains("Trip"), true ,"Response boday contains Trip");
	   
	    }else{
			Reporter.log("Status code " + resp1.statusCode());
			assertTrue(false);
		}
		}
		
	}
