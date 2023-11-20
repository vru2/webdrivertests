package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class B2B_getTravelerdetails extends AccountsCommon_API

{

	@Test
	public void b2bAddTraveler() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("b2bgetTravelerURL", "");
		validation( resp, "b2bgetTravelerURL", "");
		/*

		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/
		
		
		
	}

	
	
}
