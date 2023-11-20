package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;



public class AS_Health_Test_Url extends AccountsCommon_API
{
	@Test
	public void Healthtest() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("AcctHealthtestURL", "");
		validation( resp, "AcctHealthtestURL", "");
		
		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		
		
	}


}
