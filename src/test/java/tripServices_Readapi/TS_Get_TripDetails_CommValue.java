package test.java.  tripServices_Readapi;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_Get_TripDetails_CommValue extends TripserviceCommon {
	@Test(priority=1,groups={"Regression"})
	public void phoneasCommunicationValue() throws Exception{
		Response resp;
		String url =  tsendpoint+commvalue;
		Reporter.log(url);
		resp=RestAssured.get(url);
        if(resp.statusCode()==200){
			Reporter.log("Status code : " + resp.statusCode());
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			JsonPath jsonPath=new JsonPath(bodyAsString);
			String TotalElements = jsonPath.getString("totalElements");
			String Pagesize=jsonPath.getString("totalPages");
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			assertTrue(true);
		}else{
			Reporter.log("Status code : " + resp.statusCode());
			assertTrue(false);
		}
	

 }
	@Test(priority=2,groups={"Regression"})
	public void emailasCommunicationValue() throws Exception{
		Response resp1;
		Thread.sleep(2000);
		String url1=tsendpoint+commvalue1;
	    Reporter.log(url1);
	    resp1=RestAssured.get(url1);
       System.out.println(resp1.asString());
        if(resp1.statusCode()==200){
			Reporter.log("Test case passed");
			Reporter.log(resp1.asString());
		    Reporter.log("Status code is :: " + resp1.statusCode());
			ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			JsonPath jsonPath=new JsonPath(bodyAsString);
			String TotalElements = jsonPath.getString("totalElements");
			String Pagesize=jsonPath.getString("totalPages");
			Reporter.log(TotalElements);
			Reporter.log(Pagesize);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			assertTrue(true);
		}else{
			Reporter.log("Status code is :: " + resp1.statusCode());
			assertTrue(false);
		}
	

 }
}