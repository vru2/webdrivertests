package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_AppleSignin extends AccountsCommon_API
{
	@Test
	public void Account_Service_AppleSignin() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("Account_Service_AppleSignin", "");
		validation( resp, "Account_Service_AppleSignin", "");

	}


}