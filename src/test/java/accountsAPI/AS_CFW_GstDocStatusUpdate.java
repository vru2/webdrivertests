package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_CFW_GstDocStatusUpdate extends AccountsCommon_API
{
	@Test
	public void cfwGstdocstatusupdate() throws IOException, JSONException{	
		Response resp ;		
  		resp =postCall("cfwgstdocstatusupdate", "");
		validation( resp, "cfwgstdocstatusupdate", "");
		
		
	}


}
