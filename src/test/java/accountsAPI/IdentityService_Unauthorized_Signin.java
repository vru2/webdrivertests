package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class IdentityService_Unauthorized_Signin extends AccountsCommon_API
{

	@Test
	public void IdentityService_Signin() throws IOException, JSONException{	
		
		Response resp ;
  		resp =postCall("IdentityService_Signin_Unauthorized", "");
  		validation_user_update_MobileOTP( resp, "IdentityService_Signin_Unauthorized", "");
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		*/
		
	}
}
