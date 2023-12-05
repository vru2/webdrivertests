package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_Session_Status_Inactive_API extends AccountsCommon_API{

    @Test
    public void AS_Session_Status_Inactive_API() throws IOException, JSONException {
        Response resp ;
        resp =getCall("AS_Session_Status_Inactive_API", "");
        validation( resp, "AS_Session_Status_Inactive_API", "");
    }
}
