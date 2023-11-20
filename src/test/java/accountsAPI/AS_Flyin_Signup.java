package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class AS_Flyin_Signup extends AccountsCommon_API
{
	@Test
	public void signupV1() throws IOException,JSONException
	{
		Response resp;
		resp = postCall("flyinsignupV1","");
		
		validation(resp,"flyinsignup","");
				
	}
	

}


