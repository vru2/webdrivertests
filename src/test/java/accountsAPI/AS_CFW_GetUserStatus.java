package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_CFW_GetUserStatus extends AccountsCommon_API
{
	@Test
	public void Account_Service_CFW_GetUserStatus() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_CFW_GetUserStatus", "");
		validation( resp, "Account_Service_CFW_GetUserStatus", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/

}

}
