package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_RegisteredCltp_UserUpdate_WithoutOTP extends AccountsCommon_API
{

	@Test
	public void Account_Service_RegisteredCltp_UserUpdate_WithoutOTP() throws IOException,JSONException
	{
		Response resp;
		resp = postCall("Account_Service_RegisteredCltp_UserUpdate_WithoutOTP","");
		
		validation_user_update_MobileOTP(resp,"Account_Service_RegisteredCltp_UserUpdate_WithoutOTP","");
			
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());*/
		
	}
}
