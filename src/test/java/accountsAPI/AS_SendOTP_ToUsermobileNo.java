package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_SendOTP_ToUsermobileNo extends AccountsCommon_API
{

	@Test
	public void Account_Service_SendOTP_ToUsermobileNo() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("Account_Service_SendOTP_ToUsermobileNo", "");
		validation( resp, "Account_Service_SendOTP_ToUsermobileNo", "");

	}
}
