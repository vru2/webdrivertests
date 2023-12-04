package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_Fetch_details_api extends AccountsCommon_API{

    @Test
    public void AS_Fetch_details_api() throws IOException, JSONException {
        Response resp ;
        resp =getCall("AS_Fetch_details_api", "");
        validation( resp, "AS_Fetch_details_api", "");
    }
}
