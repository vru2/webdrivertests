package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_Update_UserJson extends AccountsCommon_API {

    @Test
    public void AS_Update_UserJson() throws IOException, JSONException {
        Response resp ;
        resp =postCall("AS_Update_UserJson", "");
        Verification( resp, "AS_Update_UserJson", "");

    }
}

