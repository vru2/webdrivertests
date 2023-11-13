package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Account_Service_Update_GST_Details_WithoutCookie extends AccountsCommon_API {
    @Test
    public void Account_Service_Update_GST_Details_WithoutCookie() throws IOException, JSONException {
        Response resp ;
        resp =postCall("Account_Service_Update_GST_Details_WithoutCookie", "");
        validation( resp, "Account_Service_Update_GST_Details_WithoutCookie", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}
