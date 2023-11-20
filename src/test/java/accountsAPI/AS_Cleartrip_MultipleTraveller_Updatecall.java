package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Cleartrip_MultipleTraveller_Updatecall extends AccountsCommon_API
{

	@Test
	public void Account_Service_Update_User() throws IOException,JSONException
	{
		Response resp;
		resp = postCall("Accounts_Service_Cleartrip_MultipleTraveller_Updatecall","");
		
		validation_user_update(resp,"Accounts_Service_Cleartrip_MultipleTraveller_Updatecall","");
				
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());
		*/
	}
}
