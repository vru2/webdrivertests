package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AS_Peoplecontroller_GetuserByEmail extends AccountsCommon_API
{

	@Test
	public void peoplecontroller_getuserbyemail() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("peoplecontroller_getuserbyemail", "");
		validation( resp, "peoplecontroller_getuserbyemail", "");

		ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());


	}


}
