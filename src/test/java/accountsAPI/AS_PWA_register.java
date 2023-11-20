package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class AS_PWA_register extends AccountsCommon_API

{

	@Test
	public void Accounts_Service_PWA_register () throws IOException, JSONException{

		Response resp ;		
		String Type = null;
		String url="http://accounts-service-api.cltp.com:9001/user/v2/register";
		resp =pwaregisterapi(url);


		String ReponseStr = resp.body().asString();
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());

		int statusCode = resp.getStatusCode();
		System.out.println(statusCode);

		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(statusCode!=202) {

			Assert.assertTrue(false);
		}

		if(!ReponseStr.contains("Other than 202 status is displayed")){
		}
	
		String ReponseStr1 = resp.body().asString();
		if(!ReponseStr1.contains("isRegistered")){
			Assert.assertTrue(false);
		}
	}

}

