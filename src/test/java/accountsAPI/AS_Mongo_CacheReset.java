package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Mongo_CacheReset extends AccountsCommon_API

{

	@Test
	public void Account_Service_Mongo_CacheReset() throws IOException, JSONException{
		Response resp ;		
		resp =deleteCall("Account_Service_Mongo_CacheReset", "");
		validation_user_update( resp, "Account_Service_Mongo_CacheReset", "");
		
		
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/
		
		
		
	}
}

