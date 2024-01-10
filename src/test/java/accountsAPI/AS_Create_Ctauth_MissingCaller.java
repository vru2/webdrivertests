package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_Create_Ctauth_MissingCaller extends AccountsCommon_API {

    @Test
    public void AS_Create_Ctauth_MissingCaller() throws IOException, JSONException {
        Response resp ;
        resp =postCall("AS_Create_Ctauth_MissingCaller", "");
        validation( resp, "AS_Create_Ctauth_MissingCaller", "");

    }
}
