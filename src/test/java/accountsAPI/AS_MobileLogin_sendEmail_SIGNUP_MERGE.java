package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_MobileLogin_sendEmail_SIGNUP_MERGE extends AccountsCommon_API {
	@Test
	public void Account_Service_MobileLogin_sendOTP_SIGNIN() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("Account_Service_MobileLogin_sendEmail_SIGNUP_MERGE", "");
		validation_user_update( resp, "Account_Service_MobileLogin_sendEmail_SIGNUP_MERGE", "");
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
*/

	}
}
