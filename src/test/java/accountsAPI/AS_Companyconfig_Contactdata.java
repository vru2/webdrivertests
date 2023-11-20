package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Companyconfig_Contactdata extends AccountsCommon_API
{

	@Test
	public void Companyconfig_contactdata() throws IOException, JSONException{
       		Response resp ;		
      		resp =postCall("Companyconfig_contactdata", "");
    		validation( resp, "Companyconfig_contactdata", "");
    		
    		/*ResponseBody body = resp.getBody();
    		System.out.println("Response body:" +body.asString());*/
    		}


	
	
}
