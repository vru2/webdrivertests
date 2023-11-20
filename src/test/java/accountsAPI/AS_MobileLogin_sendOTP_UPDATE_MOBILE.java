package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_MobileLogin_sendOTP_UPDATE_MOBILE extends AccountsCommon_API {
	@Test
	public void Account_Service_MobileLogin_sendOTP_SIGNIN() throws IOException, JSONException{
		
		Response resp ;		
		resp =postCall("Account_Service_MobileLogin_sendOTP_UPDATE_MOBILE", "");
		validation_user_update( resp, "Account_Service_MobileLogin_sendOTP_UPDATE_MOBILE", "");
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/
		

}
}
