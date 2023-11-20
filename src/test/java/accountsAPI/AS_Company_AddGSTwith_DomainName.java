package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Company_AddGSTwith_DomainName extends AccountsCommon_API
{
	@Test
	public void companygst() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("Account_Service_Company_AddGSTwith_DomainName", "");
		validation_Linkdepositaccount( resp, "Account_Service_Company_AddGSTwith_DomainName", "");
		
	/*	ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/	
		

	}
}
