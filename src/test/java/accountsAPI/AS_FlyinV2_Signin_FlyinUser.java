package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_FlyinV2_Signin_FlyinUser extends AccountsCommon_API
{

	@Test
	public void Account_Service_FlyinV2_Signin_FlyinUser() throws IOException, JSONException{
		
		Response resp ;		
		resp =postCall("Account_Service_FlyinV2_Signin_FlyinUser", "");
		validation( resp, "Account_Service_FlyinV2_Signin_FlyinUser", "");
		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		
}
}