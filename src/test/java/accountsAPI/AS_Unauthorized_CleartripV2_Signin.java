package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Unauthorized_CleartripV2_Signin extends AccountsCommon_API
{

	@Test
	public void flyinSignIn() throws IOException, JSONException{
		
		Response resp ;		
		resp =postCall("Accounts_Service_FLyinV2_Signin_Unauthorized", "");
		validation_user_update_MobileOTP( resp, "Accounts_Service_CleartripV2_Signin_Unauthorized", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/
		

}
}
