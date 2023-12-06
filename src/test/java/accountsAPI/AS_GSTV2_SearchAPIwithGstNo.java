package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_GSTV2_SearchAPIwithGstNo extends AccountsCommon_API
{
	@Test
	public void Account_Service_GSTsearch() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Account_Service_GSTV2_SearchAPIwithGstNo_ID", "");
		validation( resp, "Account_Service_GSTV2_SearchAPIwithGstNo_ID", "");

	}

}
