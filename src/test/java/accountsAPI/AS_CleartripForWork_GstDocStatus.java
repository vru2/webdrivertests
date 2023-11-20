package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_CleartripForWork_GstDocStatus extends AccountsCommon_API
{

	@Test
	public void get_cfwgstdocstatus() throws IOException, JSONException{
       		Response resp ;		
      		resp =getCall("get_cfwgstdocstatus", "");
    		validation( resp, "get_cfwgstdocstatus", "");
    		
    }

	
	
}
