package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_Flyin_ResetPassword extends AccountsCommon_API
{
	@Test
	public void flyinresetpasswordV2() throws IOException, JSONException{

		Response resp ;		
		resp =postCall("flyinresetpasswordV2", "");
		validation( resp, "flyinresetpasswordV2", "");
		
		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/

	}


}
