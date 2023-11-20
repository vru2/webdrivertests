package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_AuthorizeAPI_encodingCookie extends AccountsCommon_API
{

	@Test
	public void AccountService_AuthorizeAPI_encodingCookie() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_AuthorizeAPI_encodingCookie", "");
		validation( resp, "Account_Service_AuthorizeAPI_encodingCookie", "");

		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());


	}

}
