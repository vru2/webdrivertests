package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_Partnercontroller_Usersearch extends AccountsCommon_API
{
	@Test
	public void partnercontroller_usersearch() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("partnercontroller_usersearch", "");
		//validation( resp, "partnercontroller_usersearch", "");
		
		
		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		
		
		
	}

}
