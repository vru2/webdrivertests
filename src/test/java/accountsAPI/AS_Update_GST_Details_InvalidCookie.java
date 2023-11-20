package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_Update_GST_Details_InvalidCookie extends AccountsCommon_API {
    @Test
    public void Account_Service_Update_GST_Details_InvalidCookie() throws IOException, JSONException {
        Response resp ;
        resp =postCall("Account_Service_Update_GST_Details_InvalidCookie", "");
        validation( resp, "Account_Service_Update_GST_Details_InvalidCookie", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}
