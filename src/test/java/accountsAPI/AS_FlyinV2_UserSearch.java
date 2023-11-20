package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_FlyinV2_UserSearch extends AccountsCommon_API
{
	@Test
	public void flyinusersearchV2() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("flyinusersearchV2", "");
		validation( resp, "flyinusersearchV2", "");
/*

		ResponseBody body = resp.getBody();
			System.out.println("Response of API is:" + body.asString());*/
			
		
	}



}
