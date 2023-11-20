package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Travellercontroller_UpdateTraveller_FlyRegression extends AccountsCommon_API
{
	@Test
	public void travellercontroller_updatetraveller() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("Account_Service_Travellercontroller_UpdateTraveller_FlyRegression", "");
		validation( resp, "Account_Service_Travellercontroller_UpdateTraveller_FlyRegression", "");

		
		
		/*ResponseBody body = resp.getBody();
			System.out.println("Response of API is:" + body.asString());*/
	}
		
}
