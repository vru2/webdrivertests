package test.java.accountsAPI;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Account_Service_AuthorizeAPI_InvalidCookie extends AccountsCommon_API
{

    @Test
    public void Account_Service_AuthorizeAPI_InvalidCookie() throws IOException, JSONException {
        Response resp ;
        resp =getCall("Account_Service_AuthorizeAPI_InvalidCookie", "");
        validation( resp, "Account_Service_AuthorizeAPI_InvalidCookie", "");
    }
}
