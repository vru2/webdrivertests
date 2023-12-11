package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_RORRegister_API extends AccountsCommon_API {
	@Test
	public void AccountRegister() throws IOException, JSONException{
       		Response resp ;		
      		resp =postCall("AcctRegister", "");
    		validation( resp, "AcctRegister", "");
    }

}
