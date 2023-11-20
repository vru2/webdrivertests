package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_AppleSignin_WrapperAPI extends AccountsCommon_API
{
	@Test
	public void Account_Service_AppleSignin_WrapperAPI() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("Account_Service_AppleSignin_WrapperAPI", "");
		validation( resp, "Account_Service_AppleSignin_WrapperAPI", "");
		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());		

	}

}
