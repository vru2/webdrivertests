package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Promotional_Service_GetReferradetailsAPI extends AccountsCommon_API {
	@Test
	public void Promotional_Service_GetReferradetailsAPI() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Promotional_Service_GetReferradetailsAPI", "");
		validation( resp, "Promotional_Service_GetReferradetailsAPI", "");

	}
}
