package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_FlyinV2_SocialSignup extends AccountsCommon_API
{
	@Test
	public void flyinV2socialsignup() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("flyinsocialsignupV2", "");
		validation( resp, "flyinsocialsignupV2", "");

/*
		ResponseBody body = resp.getBody();
			System.out.println("Response of API is:" + body.asString());*/
			
		

	}


}
