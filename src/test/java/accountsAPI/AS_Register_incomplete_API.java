package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

public class AS_Register_incomplete_API extends AccountsCommon_API {

    @Test
    public void Register_incompete() throws JSONException {

        Response resp ;
        resp =postCall("Register_incompete", "");
        validation_Register( resp, "Register_incompete", "");

    }
}
