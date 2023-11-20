package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class AS_PWA_Fetch_DA_Details extends AccountsCommon_API
{


	@Test
	public void Accounts_Service_PWA_Fetch_DA_Details () throws IOException, JSONException{

		Response resp ;		
		String Type = null;
		String url="http://172.17.8.147:9001/r3/account/detail/1";
		resp =pwafetchDAdetails(url);


		String ReponseStr = resp.body().asString();
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());

		int statusCode = resp.getStatusCode();
		System.out.println(statusCode);

		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(statusCode!=200) {

			Assert.assertTrue(false);
		}

		if(!ReponseStr.contains("Other than 202 status is displayed")){
		}
	
		String ReponseStr1 = resp.body().asString();
		if(!ReponseStr1.contains("balance")){
			Assert.assertTrue(false);
		}
	}

}
