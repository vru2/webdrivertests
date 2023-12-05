package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_AccountMerge_API extends AccountsCommon_API {

    @Test
    public void AS_AccountMerge_API() throws IOException, JSONException {
        Response resp ;
        resp =postCall("AS_AccountMerge_API", "");
        validation( resp, "AS_AccountMerge_API", "");

    }
}
