package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_FlyinV2_SignUP extends AccountsCommon_API
{


	@Test
	public void flyinSignup() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("flyinsignupV2", "");
		validation( resp, "flyinsignupV2", "");
		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());

	}
}