package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Account_Service_AccountExitsAPI_Valid extends AccountsCommon_API {

    @Test
    public void Account_Service_AccountExitsAPI_Valid() throws IOException, JSONException {
        Response resp ;
        resp =getCall("Account_Service_AccountExitsAPI_Valid", "");
        validation( resp, "Account_Service_AccountExitsAPI_Valid", "");

    }

}
