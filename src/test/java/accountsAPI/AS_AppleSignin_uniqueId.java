package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_AppleSignin_uniqueId extends AccountsCommon_API
{

	@Test
	public void Account_Service_AppleSignin_uniqueId() throws IOException,JSONException
	{

		Response resp;
		resp = postCall("Account_Service_AppleSignin_uniqueId","");

		validation_Apple_signin(resp,"Account_Service_AppleSignin_uniqueId","");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());*/

	}
}