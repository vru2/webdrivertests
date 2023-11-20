package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Fetchdomain_nameByID extends AccountsCommon_API
{
	@Test
	public void fetchdomainname() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_Fetchdomain_nameByID", "");
		validation( resp, "Account_Service_Fetchdomain_nameByID", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/

	}
}
