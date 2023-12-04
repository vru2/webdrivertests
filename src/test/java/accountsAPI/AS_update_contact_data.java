package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_update_contact_data extends AccountsCommon_API {


    @Test
    public void AS_update_contact_data() throws IOException, JSONException {
        Response resp ;
        resp =postCall("AS_update_contact_data", "");
        validation( resp, "AS_update_contact_data", "");

    }
}

