package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_MobileLoginUpdatePersonaldetailsApi extends AccountsCommon_API {

	@Test
	public void Account_Service_MobileLoginUpdatePersonaldetailsApi() throws IOException, JSONException{
		Response resp ;		
		resp =putCall("Account_Service_MobileLoginUpdatePersonaldetailsApi", "");
		validation( resp, "Account_Service_MobileLoginUpdatePersonaldetailsApi", "");
		
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/		
		
	}
}
