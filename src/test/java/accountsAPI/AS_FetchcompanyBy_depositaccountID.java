package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_FetchcompanyBy_depositaccountID extends AccountsCommon_API
{
	@Test
	public void Account_Service_DA_GetcompanybyID() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_FetchcompanyBy_depositaccountID", "");
		validation( resp, "Account_Service_FetchcompanyBy_depositaccountID", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


	}
}
