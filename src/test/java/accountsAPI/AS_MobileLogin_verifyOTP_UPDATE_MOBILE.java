package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_MobileLogin_verifyOTP_UPDATE_MOBILE extends AccountsCommon_API  {
	@Test
	public void Account_Service_Update_User_MobileNo_OTPValidaion() throws IOException,JSONException
	{
		Response resp;
		resp = postCall("Account_Service_MobileLogin_verifyOTP_UPDATE_MOBILE","");
		
		validation_user_update_MobileOTP(resp,"Account_Service_MobileLogin_verifyOTP_SignIn","");
				
		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());
		
	}

}
