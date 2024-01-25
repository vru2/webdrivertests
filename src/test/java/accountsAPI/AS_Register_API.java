package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

public class AS_Register_API extends AccountsCommon_API {

    @Test
    public void Register_API() throws JSONException {

        Response resp ;
        resp =postCall("Register_API", "");
        Verification( resp, "Register_API", "");

    }
}
