// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Sanity_API  extends AccountsCommon_API{
	
    @Test
	public void Acct_Sanity() throws IOException, JSONException{
       		Response resp ;		
      		resp =getCall("AcctSanity", "");
    		validation( resp, "AcctSanity", "");
    }
}