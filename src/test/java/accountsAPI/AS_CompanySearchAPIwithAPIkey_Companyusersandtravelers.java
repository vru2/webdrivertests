package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_CompanySearchAPIwithAPIkey_Companyusersandtravelers extends AccountsCommon_API
{

	@Test
	public void Account_Service_companysearch() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_CompanySearchAPIwithAPIkey_Companyusersandtravelers", "");
		validation( resp, "Account_Service_CompanySearchAPIwithAPIkey_Companyusersandtravelers", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
*/

	}
}
