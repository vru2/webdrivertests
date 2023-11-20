package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_FetchCustomer_number extends AccountsCommon_API
{
	@Test
	public void Account_Service_fetchcustomerNo() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_FetchCustomer_number", "");
		validation( resp, "Account_Service_FetchCustomer_number", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/

}
}