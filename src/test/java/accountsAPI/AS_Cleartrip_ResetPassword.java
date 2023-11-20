package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Cleartrip_ResetPassword extends AccountsCommon_API
{
	@Test
	public void clrtpnresetpasswordV2() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("Account_Service_Cleartrip_ResetPassword", "");
		validation_user_update_MobileOTP( resp, "Account_Service_Cleartrip_ResetPassword", "");
		
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/

	}
}
