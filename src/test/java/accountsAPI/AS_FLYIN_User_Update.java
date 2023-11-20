package test.java.  accountsAPI;

import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_FLYIN_User_Update extends AccountsCommon_API
{
	@Test
	public void Account_Service_FLYIN_User_Update() throws IOException,JSONException, InterruptedException, ClassNotFoundException, SQLException
	{
		Response resp;
		resp = postCall("Account_Service_FLYIN_User_Update","");
		
		validation_user_update(resp,"Account_Service_FLYIN_User_Update","");
				
	/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());
		System.out.println(resp.statusCode());*/
		
	
	/*Thread.sleep(12000);
	DBValidation_Txn(resp, "C");*/
	}
}
