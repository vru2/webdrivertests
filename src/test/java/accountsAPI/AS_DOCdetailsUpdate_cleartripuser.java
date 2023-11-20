package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_DOCdetailsUpdate_cleartripuser extends AccountsCommon_API
{
	
	@Test
	public void Accounts_Service_DOCdetailsUpdate_cleartripuser() throws IOException,JSONException
	{
		Response resp;
		resp = postCall("Accounts_Service_DOCdetailsUpdate_cleartripuser","");
		
		validation_user_update(resp,"Accounts_Service_DOCdetailsUpdate_cleartripuser","");
				
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());*/
		
	}
	

}
