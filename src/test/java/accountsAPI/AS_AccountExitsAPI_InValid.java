package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_AccountExitsAPI_InValid extends AccountsCommon_API {

    @Test
    public void Account_Service_AccountExitsAPI_InValid() throws IOException, JSONException {
        Response resp ;
        resp =getCall("Account_Service_AccountExitsAPI_InValid", "");
        ErrorValidation( resp, "Account_Service_AccountExitsAPI_InValid");

    }
}
