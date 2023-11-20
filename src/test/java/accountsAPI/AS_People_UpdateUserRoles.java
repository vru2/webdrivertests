package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_People_UpdateUserRoles extends AccountsCommon_API
{
	@Test
	public void Account_Service_People_UpdateUserRoles() throws IOException, JSONException{
		Response resp ;		
		resp =putCall("Account_Service_People_UpdateUserRoles", "");
		validation( resp, "Account_Service_People_UpdateUserRoles", "");
		
	/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());	*/	
		
	}

}
