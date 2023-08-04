package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_Updatetag_SyncPut extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void Accounts_ExistingUsers() throws Exception{
		Response resp;
		Response resp1;
		String url="http://trip-service-api.cltp.com:9001/trips";
	    String param="{\"tag_masters\":[{\"id\":233266333,\"status\":\"D\"}]}";
		String param1="{\"tag_masters\":[{\"id\":233266333,\"status\":\"A\"}]}";
			System.out.println(url);
			Reporter.log(url);
			resp=RestAssured.given().
				when().
				log().all().
				body(param).
				headers("Content-Type", "application/json").
				headers("trip-version","V2").
				put(url);
	     if(resp.statusCode()==200){
	    	System.out.println(resp.asString());
	    	Reporter.log(resp.asString());
		    Reporter.log("Status code " + resp.statusCode());
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("tag_masters"), true ,"Response boday contains tag_masters");
			Assert.assertNotNull("tag_masters");
			Assert.assertEquals(bodyAsString.contains("source_type"), true ,"Response boday contains source_type");
			Assert.assertNotNull("source_type");
			Assert.assertNotNull("status");
			Assert.assertNotNull("id");
			
		}else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
	     
	     resp1=RestAssured.given().
					when().
					log().all().
					body(param1).
					headers("Content-Type", "application/json").
					headers("trip-version","V2").
					put(url);
		     if(resp1.statusCode()==200){
		    	System.out.println(resp1.asString());
		    	Reporter.log(resp1.asString());
			    Reporter.log("Status code " + resp1.statusCode());
				ResponseBody body= resp1.getBody();
				String bodyAsString = body.asString();
				Assert.assertEquals(bodyAsString.contains("tag_masters"), true ,"Response boday contains tag_masters");
				Assert.assertNotNull("tag_masters");
				Assert.assertEquals(bodyAsString.contains("source_type"), true ,"Response boday contains source_type");
				Assert.assertNotNull("source_type");
				Assert.assertNotNull("status");
				Assert.assertNotNull("id");
				
			}else{
				Reporter.log("Status code " + resp1.statusCode());
				assertTrue(false);
			}
	     
		
	}
	}
