package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_FlyinUser_GSTdetailsUpdate extends AccountsCommon_API
{

	@Test
	public void Accounts_Service_FLyinUser_GSTdetailsUpdate() throws IOException,JSONException
	{
		Response resp;
		resp = postCall("Accounts_Service_FLyinUser_GSTdetailsUpdate","");
		
		validation_user_update(resp,"Accounts_Service_FLyinUser_GSTdetailsUpdate","");
				
	ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());
		
	}
}
