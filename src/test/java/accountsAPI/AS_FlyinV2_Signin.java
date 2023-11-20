package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_FlyinV2_Signin extends AccountsCommon_API
{
	@Test
	public void flyinSignIn() throws IOException, JSONException{
		
		Response resp ;		
		resp =postCall("flyinsigninV2", "");
		validation( resp, "flyinsigninV2", "");
/*
		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/
		

}
}