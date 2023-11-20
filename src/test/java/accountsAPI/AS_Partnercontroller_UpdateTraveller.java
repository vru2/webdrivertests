package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Partnercontroller_UpdateTraveller extends AccountsCommon_API
{
	
	@Test
	public void partnercontroller_updatetraveller() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("partnercontroller_updatetraveller", "");
		validation( resp, "partnercontroller_updatetraveller", "");

/*
		ResponseBody body = resp.getBody();
			System.out.println("Response of API is:" + body.asString());*/
			
		
	}

}
