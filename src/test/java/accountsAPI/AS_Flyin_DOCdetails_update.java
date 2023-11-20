package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Flyin_DOCdetails_update extends AccountsCommon_API
{

	@Test
	public void Accounts_Service_Flyin_DOCdetails_update() throws IOException,JSONException
	{
		Response resp;
		resp = postCall("Accounts_Service_Flyin_DOCdetails_update","");
		
		validation_user_update(resp,"Accounts_Service_Flyin_DOCdetails_update","");
				
	/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());*/
		
	}
}
