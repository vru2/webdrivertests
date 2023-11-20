package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_MobileLogin_NudgeUpdateMobile extends AccountsCommon_API  {
	@Test
	public void Account_Service_MobileLogin_NudgeUpdateMobile() throws IOException,JSONException
	{
		Response resp;
		resp = postCall("Account_Service_MobileLogin_NudgeUpdateMobile","");
		
		validation(resp,"Account_Service_MobileLogin_NudgePersonaldetails","");
				
		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());
		
	}
}
