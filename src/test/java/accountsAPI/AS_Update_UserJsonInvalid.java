package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_Update_UserJsonInvalid extends AccountsCommon_API {

    @Test
    public void AS_Update_UserJsonInvalid() throws IOException, JSONException {
        Response resp ;
        resp =postCall("AS_Update_UserJsonInvalid", "");
        validation( resp, "AS_Update_UserJsonInvalid", "");

    }
}
