package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Account_Service_Update_Personal_Details extends AccountsCommon_API
{
    @Test
    public void Account_Service_Update_Personal_Details() throws IOException, JSONException {
        Response resp ;
        resp =putCall("Account_Service_Update_Personal_Details", "");
        validation( resp, "Account_Service_Update_Personal_Details", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }

}
