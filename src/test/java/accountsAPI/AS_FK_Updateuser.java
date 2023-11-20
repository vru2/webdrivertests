package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_FK_Updateuser extends AccountsCommon_API
{

	@Test
	public void Account_Service_flipkart() throws IOException, JSONException{
		Response resp ;		
		resp =putCall("Flipkart_Accounts_service_Updateuser", "");
		validation( resp, "Flipkart_Accounts_service_Updateuser", "");
		
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());	*/	
		
	}
}
