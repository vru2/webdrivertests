package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_DA_Search_With_Linkable_Type extends AccountsCommon_API
{
	@Test
	public void Account_Service_DA_GetcompanybyID() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_Depositaccountsearch_WOTlinkedparam", "");
		validation( resp, "Account_Service_Depositaccountsearch_WOTlinkedparam", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


	}
}
