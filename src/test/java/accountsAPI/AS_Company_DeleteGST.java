package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Company_DeleteGST extends AccountsCommon_API
{
	@Test
	public void Account_Service_deletegst() throws IOException, JSONException{
		Response resp ;		
		resp =deleteCall("Accounts_service_Company_DeleteGST", "");
		validation_AppleRegister_NullEmail( resp, "Accounts_service_Company_DeleteGST", "");
		
	/*	ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());		*/
		
	}

}
