package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_People_AutoComplete extends AccountsCommon_API
{
	
	
	
	@Test
	public void get_cfwoptinstatus() throws IOException, JSONException{
       		Response resp ;		
      		resp =getCall("peopleautocomplete", "");
    		validation( resp, "peopleautocomplete", "");
    	/*	ResponseBody body = resp.getBody();
    		System.out.println("Response of API is:" + body.asString());*/
    }



}
