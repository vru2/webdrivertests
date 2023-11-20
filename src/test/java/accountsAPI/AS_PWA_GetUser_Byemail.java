package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_PWA_GetUser_Byemail extends AccountsCommon_API
{

	@Test
	public void Account_Service_PWA_GetUser_Byemail() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_PWA_GetUser_Byemail", "");
		validation( resp, "Account_Service_PWA_GetUser_Byemail", "");

		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());


	}
}
