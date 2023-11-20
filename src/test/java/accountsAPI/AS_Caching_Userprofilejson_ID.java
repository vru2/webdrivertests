package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Caching_Userprofilejson_ID extends AccountsCommon_API
{
	@Test
	public void Account_Service_Caching_Userprofilejson_ID() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_Caching_Userprofilejson_ID", "");
		validation( resp, "Account_Service_Caching_Userprofilejson_ID", "");
		
		
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		*/
		
		
	}

}
