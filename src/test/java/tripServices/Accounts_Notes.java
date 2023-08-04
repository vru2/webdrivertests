package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Accounts_Notes extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void Accounts_ExistingUsers() throws Exception{
		Response resp;
		Response resp1;
		String url_qa="http://trip-service-api.cltp.com:9001/api/trips/notes?id=57046380";
		Reporter.log(url_qa);
	    resp=RestAssured.get(url_qa);
	    if(resp.statusCode()==200){
	    	Reporter.log(resp.asString());
	    	System.out.println(resp.asString());
		    Reporter.log("Status code " + resp.statusCode());
			Assert.assertNotNull("id");
			Assert.assertNotNull("note");
			Assert.assertNotNull("subject");
			Assert.assertNotNull("user_id");
			Assert.assertNotNull("trip_id");
			
	    }else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
   }
}
