package test.java.  accountsAPI;

import java.io.IOException;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import org.json.JSONException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Account_Service_UserController_VerifyAccount_UsernotPresent extends AccountsCommon_API{
	@Test
	public void Account_Service_UserController_VerifyAccount() throws IOException, JSONException{
		Response resp ;		
		resp =putCall("Account_Service_UserController_VerifyAccount_UsernotPresent", "");
		//validation_AppleRegister_NullEmail( resp, "Account_Service_UserController_VerifyAccount_UsernotPresent", "");

		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		if(statusCode!=404) {
			Assert.assertTrue(false);
		}

			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("User not found with id : 1402954698")) {
				Assert.assertTrue(false);
			}

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());		
		*/
	}

}
