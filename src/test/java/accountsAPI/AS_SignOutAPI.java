package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_SignOutAPI extends AccountsCommon_API{

    @Test
    public void AS_SignOutAPI() throws IOException, JSONException {
        Response resp ;
        resp =getCall("AS_SignOutAPI", "");
        validation( resp, "AS_SignOutAPI", "");
    }
}
