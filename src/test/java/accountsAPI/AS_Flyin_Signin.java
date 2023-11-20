package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Flyin_Signin extends AccountsCommon_API
{
	@Test
	public void flyinSignIn() throws IOException, JSONException{
	
	Response resp ;		
	resp =postCall("flyinsigninV1", "");
	validation( resp, "flyinsignin", "");
	
}



}
