package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;



public class Account_Service_LogOutAPI extends AccountsCommon_API {

    @Test
    public void Account_Service_LogOutAPI() throws IOException, JSONException {
        Response resp ;
        resp =getCall("Account_Service_LogOutAPI", "");
        validation( resp, "Account_Service_LogOutAPI", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}