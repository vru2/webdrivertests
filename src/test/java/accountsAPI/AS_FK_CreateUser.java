package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_FK_CreateUser extends AccountsCommon_API
{
	@Test
	public void flipkartcreateuser() throws IOException, JSONException{	
		
		Response resp ;
  		resp =postCall("Flipkart_Accounts_Service_CreateUser", "");
  		validation_user_update( resp, "Flipkart_Accounts_Service_CreateUser", "");
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/
		
		
	}
}
