package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_Create_Ctauth_Invalid extends AccountsCommon_API {

    @Test
    public void AS_Create_Ctauth_Invalid() throws IOException, JSONException {
        Response resp ;
        resp =postCall("AS_Create_Ctauth_Invalid", "");
        validation_user_update_MobileOTP( resp, "AS_Create_Ctauth_Invalid", "");

    }
}