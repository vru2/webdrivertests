package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_Config_Getcall_APIKey  extends AccountsCommon_API
{

	
	@Test
	public void apiConfig_APIkey() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("apiConfig_APIkey", "");
		validation( resp, "apiConfig_APIkey", "");

	}

}
