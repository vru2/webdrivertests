package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Cleartrip_confirmedtravlerwithActivestatus extends AccountsCommon_API
{
	@Test
	public void Account_Service_confirmedtraveler() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("Account_Service_Cleartrip_confirmedtravlerwithActivestatus", "");
		validation_user_update( resp, "Account_Service_Cleartrip_confirmedtravlerwithActivestatus", "");
	/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());*/
	}


}

