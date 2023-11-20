package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_AppleSignin_Entity extends AccountsCommon_API
{
	@Test
	public void Account_Service_AppleSignin_Entity() throws IOException,JSONException
	{

		Response resp;
		resp = postCall("Account_Service_AppleSignin_Entity","");

		validation_Apple_signin_entity(resp,"Account_Service_AppleSignin_Entity","");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());
*/
	}

}
