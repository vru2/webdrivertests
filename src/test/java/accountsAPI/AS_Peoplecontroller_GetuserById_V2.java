package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_Peoplecontroller_GetuserById_V2 extends AccountsCommon_API
{
	@Test
	public void peoplecontroller_getuserbyid_v2() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("peoplecontroller_getuserbyid_v2", "");
		validation( resp, "peoplecontroller_getuserbyid_v2", "");

		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());


	}



}
