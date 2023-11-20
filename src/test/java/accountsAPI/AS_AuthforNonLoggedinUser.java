package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_AuthforNonLoggedinUser extends AccountsCommon_API
{
	@Test
	public void Account_Service_UserController_VerifyAccount() throws IOException, JSONException{
		Response resp ;		
		resp =putCall("Account_Service_AuthforNonLoggedinUser", "");
		validation( resp, "Account_Service_AuthforNonLoggedinUser", "");
		
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());	*/	
		
	}

}
