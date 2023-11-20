package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Update_User extends AccountsCommon_API
{

	@Test
	public void Account_Service_Update_User() throws IOException,JSONException
	{
		Response resp;
		resp = postCall("Account_Service_Update_User","");
		
		validation_user_update(resp,"Account_Service_Update_User","");
				
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());*/
		
	}
	
		
}

	