package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Applesignin_Unauthorized extends AccountsCommon_API
{
	
		@Test
		public void Account_Service_AppleSignin_unauthorized() throws IOException, JSONException{

			Response resp ;		
			resp =postCall("Accounts_Service_Applesignin_Unauthorized", "");
			validation_Apple_signin( resp, "Accounts_Service_Applesignin_Unauthorized", "");

		}

}
