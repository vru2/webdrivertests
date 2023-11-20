package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_RegisterFlyinUserUpdate_OTPValidation extends AccountsCommon_API
{
	@Test
	public void Account_Service_RegisterFLyinUserUpdate_OTPValidation() throws IOException,JSONException
	{
		Response resp;
		resp = postCall("Account_Service_RegisterFLyinUserUpdate_OTPValidation","");
		
		validation_user_update(resp,"Account_Service_RegisterFLyinUserUpdate_OTPValidation","");
				
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());*/
		
	}

}