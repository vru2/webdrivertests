package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class B2B_Addtraveler extends AccountsCommon_API
{

	@Test
	public void b2bAddtraveler() throws IOException, JSONException{
		Response resp ;		
		resp =postCall("b2bAddtraveler","");
		System.out.println(resp.asString());
		validation( resp, "b2bAddtraveler", "");
/*
		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/
	
	
}
}