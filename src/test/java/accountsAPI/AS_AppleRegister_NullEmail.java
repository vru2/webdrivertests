package test.java.  accountsAPI;

import java.io.IOException;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import org.json.JSONException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_AppleRegister_NullEmail extends AccountsCommon_API
{

	@Test
	public void Account_Service_AppleRegister_NullEmail() throws IOException,JSONException
	{

		Response resp;
		resp = postCall("Account_Service_AppleRegister_NullEmail","");

	//	validation_AppleRegister_NullEmail(resp,"Account_Service_AppleRegister_NullEmail","");

		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		if(statusCode!=404) {
			Assert.assertTrue(false);
		}

			String username = jsonPathEvaluator.getString("message");
			if(!username.contains("No user found with appleId : 1:a:2:b:3:00")) {
				Assert.assertTrue(false);

		}

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());*/

	}
}
