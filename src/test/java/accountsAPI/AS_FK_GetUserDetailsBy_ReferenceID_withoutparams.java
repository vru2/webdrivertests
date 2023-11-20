package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_FK_GetUserDetailsBy_ReferenceID_withoutparams extends AccountsCommon_API
{
	@Test
	public void flipkartgetuserdetails() throws IOException, JSONException{
		Response resp ;		
		resp =getCall("Flipkart_Accounts_service_GetUserDetailsBy_ReferenceID_withoutparams", "");
		validation( resp, "Flipkart_Accounts_service_GetUserDetailsBy_ReferenceID_withoutparams", "");

	/*	ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
*/
}

}
