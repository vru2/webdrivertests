package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_GET_Tripscount_Personid extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void getTripService() throws IOException{
		String url=Service_Url("TRIPSERVICE_GETTRIPCOUNT_CALL");
		System.out.println(url);
		Reporter.log(url);
		Response resp=RestAssured.get(url);
		System.out.println(resp.asString());
		if(resp.statusCode()==200){
			Reporter.log(resp.body().asString());
			Reporter.log("Status code " + resp.statusCode());
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			JsonPath jsonPath=new JsonPath(bodyAsString);
			String id=jsonPath.getString("id");
			String person_id=jsonPath.getString("person_id");
			String dom_count=jsonPath.getString("dom_count");
		    Assert.assertEquals(bodyAsString.contains("id"),true,"Response body contains id");
		    Assert.assertEquals(bodyAsString.contains("person_id"),true,"Response body contains person id");
		    Assert.assertEquals(bodyAsString.contains("dom_count"),true,"Response body contains person dom_count");
		    Reporter.log(id);
		    Reporter.log(person_id);
		    Reporter.log(dom_count);
	 }else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
	}


}
