package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_Update_GST_Details_InValidGST extends AccountsCommon_API {
    @Test
    public void Account_Service_Update_GST_Details_InValidGST() throws IOException, JSONException {
        Response resp ;
        resp =postCall("Account_Service_Update_GST_Details_InValidGST", "");
        validation( resp, "Account_Service_Update_GST_Details_InValidGST", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}
