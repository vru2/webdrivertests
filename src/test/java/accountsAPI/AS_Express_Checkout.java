package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Express_Checkout extends AccountsCommon_API
{
	@Test
	public void Account_Service_Express_Checkout() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("Account_Service_Express_Checkout", "");
		validation( resp, "Account_Service_Express_Checkout", "");
		
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());	*/
		

	}
}
