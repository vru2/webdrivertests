package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Userprofile_Caching_Json_Email extends AccountsCommon_API
{
	@Test
	public void Account_Service_Caching_Userprofilejson_Email() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_Caching_Userprofilejson_Email", "");
		validation( resp, "Account_Service_Caching_Userprofilejson_Email", "");
		
		
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/
		
		
		
	}

}
