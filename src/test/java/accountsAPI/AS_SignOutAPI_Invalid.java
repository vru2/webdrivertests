package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_SignOutAPI_Invalid extends AccountsCommon_API{

    @Test
    public void AS_SignOutAPI_Invalid() throws IOException, JSONException {
        Response resp ;
        resp =getCall("AS_SignOutAPI_Invalid", "");
        validation( resp, "AS_SignOutAPI_Invalid", "");

    }
}
