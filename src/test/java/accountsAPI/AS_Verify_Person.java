package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Verify_Person extends AccountsCommon_API
{

	@Test
	public void Account_Service_Verify_Person() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_Verify_Person", "");
		validation( resp, "Account_Service_Verify_Person", "");
		
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/
		
		
	}
}
