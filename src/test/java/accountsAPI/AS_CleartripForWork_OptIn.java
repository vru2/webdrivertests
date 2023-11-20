package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_CleartripForWork_OptIn extends AccountsCommon_API
{
	
	@Test
	public void cleartripForWorkOptin() throws IOException, JSONException{	
		Response resp ;		
  		resp =postCall("cleartripForWorkOptin", "");
		validation( resp, "cleartripForWorkOptin", "");
		
	}


}
