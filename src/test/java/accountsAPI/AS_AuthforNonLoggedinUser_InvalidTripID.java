package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_AuthforNonLoggedinUser_InvalidTripID extends AccountsCommon_API
{
	@Test
	public void Account_Service_nonloginser() throws IOException, JSONException{
		Response resp ;		
		resp =putCall("Account_Service_AuthforNonLoggedinUser_InvalidTripID", "");
		validation_AppleRegister_NullEmail( resp, "Account_Service_AuthforNonLoggedinUser_InvalidTripID", "");
		

	}


}
