package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Flyin_Social_Signup extends AccountsCommon_API
{
	@Test
	
	public void Flyinsocialsignup() throws IOException, JSONException
	{
	Response resp;
	resp = postCall("flyinsocialsignupV1", "");
	validation(resp, "flyinsignup","");/*
	
	ResponseBody body = resp.getBody();
	System.out.println("Response of API is:" + body.asString());*/
	
	}

}
