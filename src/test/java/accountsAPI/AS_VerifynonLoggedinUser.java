package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_VerifynonLoggedinUser extends AccountsCommon_API
{

	@Test
	public void Accounts_Service_VerifynonLoggedinUser() throws IOException, JSONException{
		Response resp ;		
		resp =putCall("Accounts_Service_VerifynonLoggedinUser", "");
		validation_AppleRegister_NullEmail( resp, "Accounts_Service_VerifynonLoggedinUser", "");
		/*
		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/		
		
	}
}
