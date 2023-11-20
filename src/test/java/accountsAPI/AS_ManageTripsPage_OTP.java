package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_ManageTripsPage_OTP extends AccountsCommon_API
{

	@Test
	public void Manage_trips_OTP_API() throws IOException, JSONException{
	
	Response resp ;		
	resp =postCall("Manage_trips_OTP_API", "");
	validation( resp, "Manage_trips_OTP_API", "");
	/*ResponseBody body = resp.getBody();
	System.out.println("Response of API is:" + body.asString());*/

}

}
