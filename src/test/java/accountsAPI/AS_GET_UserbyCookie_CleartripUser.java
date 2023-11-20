package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_GET_UserbyCookie_CleartripUser extends AccountsCommon_API
{
	@Test
	public void Account_Service_Getuser() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_GET_UserbyCookie_CleartripUser", "");
		validation( resp, "Account_Service_GET_UserbyCookie_CleartripUser", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


	}
}
