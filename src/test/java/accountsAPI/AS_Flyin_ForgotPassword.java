package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Flyin_ForgotPassword extends AccountsCommon_API
{
	@Test
	public void flyinforgetpasswordV2() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("flyinforgetpasswordV2", "");
		validation( resp, "flyinforgetpasswordV2", "");

		
	}


}
